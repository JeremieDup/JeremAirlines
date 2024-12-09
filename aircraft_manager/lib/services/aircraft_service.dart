import 'dart:convert';
import 'package:http/http.dart' as http;

class AircraftService {
  final String baseUrl = 'http://localhost:8080/api/aircrafts';

  Future<List<dynamic>> fetchAircrafts() async {
    final response = await http.get(Uri.parse(baseUrl));
    if (response.statusCode == 200) {
      return json.decode(response.body);
    } else {
      throw Exception('Failed to load aircrafts');
    }
  }
}