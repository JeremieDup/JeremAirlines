import 'package:flutter/material.dart';
import 'services/aircraft_service.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Aircraft Manager',
      home: AircraftList(),
    );
  }
}

class AircraftList extends StatefulWidget {
  @override
  _AircraftListState createState() => _AircraftListState();
}

class _AircraftListState extends State<AircraftList> {
  final AircraftService _service = AircraftService();
  late Future<List<dynamic>> _aircrafts;

  @override
  void initState() {
    super.initState();
    _aircrafts = _service.fetchAircrafts();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Aircrafts')),
      body: FutureBuilder<List<dynamic>>(
        future: _aircrafts,
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Center(child: Text('Error: ${snapshot.error}'));
          } else if (!snapshot.hasData || snapshot.data!.isEmpty) {
            return Center(child: Text('No aircrafts found'));
          } else {
            return ListView.builder(
              itemCount: snapshot.data!.length,
              itemBuilder: (context, index) {
                var aircraft = snapshot.data![index];
                return ListTile(
                  title: Text('${aircraft['brand']} ${aircraft['model']}'),
                  subtitle: Text('Capacity: ${aircraft['capacity']}'),
                );
              },
            );
          }
        },
      ),
    );
  }
}