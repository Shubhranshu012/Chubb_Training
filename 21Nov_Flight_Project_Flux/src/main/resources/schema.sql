-- ===============================
-- Flights table
-- ===============================
CREATE TABLE IF NOT EXISTS flights (
    flight_number VARCHAR(50) PRIMARY KEY,
    airline_name VARCHAR(255),
    from_place VARCHAR(255),
    to_place VARCHAR(255)
);

-- ===============================
-- Flight Inventory table
-- ===============================
CREATE TABLE IF NOT EXISTS flight_inventory (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    flight_number VARCHAR(50),
    departure_time TIMESTAMP,
    arrival_time TIMESTAMP,
    price DOUBLE,
    total_seats INT,
    available_seats INT,
    active BOOLEAN
);

-- ===============================
-- Bookings table
-- ===============================
CREATE TABLE IF NOT EXISTS bookings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    pnr VARCHAR(50),
    email VARCHAR(255),
    booking_time TIMESTAMP,
    departure_time TIMESTAMP,
    arrival_time TIMESTAMP,
    journey_date_time TIMESTAMP,
    total_price DOUBLE,
    cancelled BOOLEAN,
    cancelled_at TIMESTAMP,
    inventory_id BIGINT,
    flight_number VARCHAR(50)
);

-- ===============================
-- Passengers table
-- ===============================
CREATE TABLE IF NOT EXISTS passengers (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    booking_id BIGINT,
    name VARCHAR(255),
    gender VARCHAR(50),
    age INT,
    seat_number VARCHAR(20),
    meal_option VARCHAR(50)
);
