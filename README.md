# DRIVER-RIDER-

A Java-based ride-hailing system where riders can find available drivers, start rides, stop rides, and calculate fares.

**Problem Statement**

The goal of this project is to build a ride-hailing system that allows users (riders) to book rides, match with the nearest available driver, start and stop rides, 
and calculate fare based on distance and time. The system should also handle various edge cases like drivers not being available, duplicate ride IDs, and stopping non-existent rides.

**FEATURES**
 Add and manage drivers and riders
 Assign the nearest available driver to a rider
 Start and stop rides
 Calculate ride fares based on distance and time
 Handle scenarios like driver not available, duplicate ride ID, stopping a non-existent ride.

 
**PROJECT STRUCTURE**
src/
│── main/
│   ├── controllers/        # Handles ride-related commands
│   ├── models/             # Entity classes (Driver, Rider, Ride)
│   ├── repository/         # Data storage (DriverData, RideData)
│   ├── services/           # Business logic (RideManager, DriverManager, BillingCalculator, DistanceCalculator)
│── test/                   # JUnit test cases

**Models (Data Entities)**

Driver.java: Represents a driver with ID, location, and availability.

Rider.java: Represents a rider with ID and location.

Ride.java: Stores details of an ongoing ride, including driver, rider, start location, and status.

2️ **Services (Business Logic)**

DriverManager.java: Manages driver registration and availability.

RideManager.java: Handles ride creation, starting, stopping, and fare calculation.

BillingCalculator.java: Calculates the total fare for a ride based on distance and time.

DistanceCalculator.java: Computes the shortest distance between two points.

3️**Repository (Data Storage & Retrieval)**

DriverData.java: Stores all registered drivers and their availability.

RideData.java: Manages active and completed rides.

**Running Tests**

Includes test cases for:

Driver Not Available

Rider Not Available

Duplicate Ride ID

Stopping a Non-Existent Ride

**Sample Input:**

ADD_DRIVER D1 1 1
ADD_DRIVER D2 4 5
ADD_RIDER R1 0 0
MATCH R1
START_RIDE RIDE-001 D2 R1
STOP_RIDE RIDE-001 4 5 32
BILL RIDE-001

**Expected Output**

DRIVERS_MATCHED D1 D2
RIDE_STARTED RIDE-001
RIDE_STOPPED RIDE-001
BILL RIDE-001 D2 186.72


 
