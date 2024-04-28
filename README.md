# Hadoop MapReduce Exercises

This repository contains implementations of 8 MapReduce exercises, each with separate drivers, mappers, and reducers. The exercises cover various tasks such as word count, data analysis, and income calculation. The inputs and outputs are defined in the launch.json file for each exercise, and each class can be launched separately.

These exercises were developed as part of a Big Data course offered in the Master of Science program in Data Science and Analytics specialization at EPITA.


## Table of Contents

1. [Setup](#setup)
2. [Exercises](#exercises)
    - [Exercise 1: Word Count](#exercise-1-word-count)
    - [Exercise 2: Word Count per File](#exercise-2-word-count-per-file)
    - [Exercise 3: PM10 Pollution Analysis](#exercise-3-pm10-pollution-analysis)
    - [Exercise 4: PM10 Pollution Analysis per City Zone](#exercise-4-pm10-pollution-analysis-per-city-zone)
    - [Exercise 5: Average PM10 Value per Sensor](#exercise-5-average-pm10-value-per-sensor)
    - [Exercise 6: Max and Min PM10 Values per Sensor](#exercise-6-max-and-min-pm10-values-per-sensor)
    - [Exercise 7: Inverted Index](#exercise-7-inverted-index)
    - [Exercise 8: Total Income and Average Monthly Income](#exercise-8-total-income-and-average-monthly-income)
3. [Usage](#usage)
4. [Running the code](#running-the-code)
5. [Contributing](#contributing)
6. [License](#license)

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/Beemnet/bigdata-hadoop-exercises.git
    ```

2. Set up your Hadoop environment.

3. Ensure Java and Hadoop are properly configured on your system.

## Exercises

### Exercise 1: Word Count

This exercise involves counting the occurrences of each word in a collection of text documents.

### Exercise 2: Word Count per File

Similar to Exercise 1, but this time, the word count is performed separately for each input file.

### Exercise 3: PM10 Pollution Analysis

This exercise analyzes the pollution levels (PM10) recorded by sensors. It calculates the average PM10 value for each sensor.

### Exercise 4: PM10 Pollution Analysis per City Zone

Extending Exercise 3, this exercise categorizes sensors into different city zones and calculates the average PM10 value for each zone.

### Exercise 5: Average PM10 Value per Sensor

Another variation of Exercise 3, this exercise calculates the average PM10 value for each sensor over a period of time.

### Exercise 6: Max and Min PM10 Values per Sensor

This exercise determines the maximum and minimum PM10 values recorded by each sensor.

### Exercise 7: Inverted Index

This exercise builds an inverted index, mapping words to the list of sentence IDs in which they occur, excluding common words like "and", "or", and "not".

### Exercise 8: Total Income and Average Monthly Income

This exercise calculates the total income for each month of the year and the average monthly income per year, considering only the months with a total income greater than 0.

## Usage

To run each exercise, use the provided launch.json configuration for your IDE or execute the corresponding driver class from the command line. The outputs of each function can be found in the output folders of each exercise

## Running the code

To observe the behavior of each function, delete the output folders for each exercise before running the MapReduce job again. The output directories are specified in the launch.json file for each exercise.

## Contributing

Pull requests and contributions are welcome. For major changes, please open an issue first to discuss what you would like to change.
Feel free to fork this repository to explore the exercises, experiment with the code, or use them for your own learning purposes.


This is an example Java project used in Codeanywhere.

[Try it out](https://app.codeanywhere.com/#https://github.com/Codeanywhere-Templates/java)
