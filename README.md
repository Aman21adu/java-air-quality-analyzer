# Air Quality Analyzer & Alert System

## Overview
This Java console project analyzes air quality index (AQI) data from a CSV file and provides statistics and alerts for unhealthy days.

## Motivation
Monitoring air quality is crucial for public health, especially in areas with limited access to real-time environmental data. This project simulates an easy-to-use analysis system suitable for educational purposes and citizen science projects.

## Technologies Used
- Java 17
- File I/O
- Collections API
- Basic data analysis

## How It Works
1. Reads AQI values from `data/aqi_sample.csv`.
2. Calculates maximum, minimum, and average AQI.
3. Prints alerts for days exceeding the safe AQI threshold.

## Challenges Faced
- Reading and validating CSV data.
- Handling invalid entries without crashing the program.
- Providing meaningful alerts and statistics.

## What I Learned
- File handling and exception management in Java.
- Using Lists and Streams for data processing.
- Basic environmental data analysis techniques.

## Status
Completed

This project is exploratory and educational in nature and does not claim to
represent real-time environmental measurements.

## Optional Visuals
![Air Quality Chart](assets/air_quality_chart.png)

