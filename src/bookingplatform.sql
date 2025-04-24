CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Theatres (
    theatre_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    address TEXT NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Movies (
    movie_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    language VARCHAR(50) NOT NULL,
    genre VARCHAR(100),
    duration INT CHECK (Duration > 0),
    release_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Shows (
    show_id SERIAL PRIMARY KEY,
    theatre_id BIGINT UNSIGNED,
    movie_id BIGINT UNSIGNED,
    show_date DATE NOT NULL,
    show_time TIME NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_theatre FOREIGN KEY (theatre_id) REFERENCES Theatres(theatre_id) ON DELETE CASCADE,
    CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES Movies(movie_id) ON DELETE CASCADE
);


CREATE TABLE Seats (
    seat_id SERIAL PRIMARY KEY,
    theatre_id INT REFERENCES Theatres(theatre_id),
    seat_number VARCHAR(10) NOT NULL,
    type VARCHAR(50) CHECK (type IN ('Regular', 'Premium')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ShowSeats (
    show_seat_id SERIAL PRIMARY KEY,
    show_id INT REFERENCES Shows(show_id),
    seat_id INT REFERENCES Seats(seat_id),
    status VARCHAR(50) CHECK (status IN ('Available', 'Booked', 'Reserved')),
    price DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Bookings (
    booking_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED,
    show_id BIGINT UNSIGNED,
    booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2) NOT NULL,
    status ENUM('Confirmed', 'Cancelled', 'Pending') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (show_id) REFERENCES Shows(show_id) ON DELETE CASCADE
);

CREATE TABLE Payments (
    payment_id SERIAL PRIMARY KEY,
    booking_id INT REFERENCES Bookings(booking_id),
    amount DECIMAL(10,2) NOT NULL,
    payment_status VARCHAR(50) CHECK (payment_status IN ('Success', 'Failed', 'Pending')),
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


INSERT INTO Users (name, email, password)
VALUES
    ('Alice Johnson', 'alice@example.com', 'hashedpassword1'),
    ('Bob Smith', 'bob@example.com', 'hashedpassword2'),
    ('Charlie Brown', 'charlie@example.com', 'hashedpassword3'),
    ('Diana Prince', 'diana@example.com', 'hashedpassword4'),
    ('Ethan Hunt', 'ethan@example.com', 'hashedpassword5'),
    ('Fiona Gallagher', 'fiona@example.com', 'hashedpassword6'),
    ('George Clooney', 'george@example.com', 'hashedpassword7'),
    ('Hannah Montana', 'hannah@example.com', 'hashedpassword8');

INSERT INTO Theatres (name, city, address, email, phone)
VALUES
    ('Theatres1', 'Delhi', 'Address-Theatres1', 'contact@regal.com', '123-456-7890'),
    ('Theatres2', 'Bangalore', 'Address-Theatres2', 'info@amctheatres.com', '987-654-3210'),
    ('Theatres3', 'Pune', 'Address-Theatres3', 'support@cineplex.com', '555-666-7777'),
    ('Theatres4', 'Mumbai', 'Address-Theatres4', 'contact@mumbaitheatre.com', '111-222-3333'),
    ('Theatres5', 'Chennai', 'Address-Theatres5', 'info@chennaicinema.com', '444-555-6666'),
    ('Theatres6', 'Hyderabad', 'Address-Theatres6', 'support@hydtheatre.com', '777-888-9999'),
    ('Theatres7', 'Kolkata', 'Address-Theatres7', 'contact@kolkatacinema.com', '222-333-4444'),
    ('Theatres8', 'Ahmedabad', 'Address-Theatres8', 'info@ahmtheatre.com', '888-999-0000');

-- Insert data into Movies table
INSERT INTO Movies (title, language, genre, duration, release_date) VALUES
    ('The Lost City', 'English', 'Adventure', 112, '2022-03-25'),
    ('Pathaan', 'Hindi', 'Action', 146, '2023-01-25'),
    ('RRR', 'Telugu', 'Action/Drama', 182, '2022-03-24'),
    ('Coco', 'English', 'Animation', 105, '2017-11-22'),
    ('3 Idiots', 'Hindi', 'Comedy/Drama', 170, '2009-12-25'),
    ('Parasite', 'Korean', 'Thriller', 132, '2019-05-30'),
    ('Dune', 'English', 'Sci-Fi', 155, '2021-10-22');

-- Insert data into Shows table
INSERT INTO Shows (theatre_id, movie_id, show_date, show_time, price) VALUES
    (1, 1, '2025-03-10', '18:00:00', 12.50),
    (1, 3, '2025-03-11', '20:30:00', 15.00),
    (2, 2, '2025-03-12', '19:00:00', 10.00),
    (3, 1, '2025-03-13', '21:00:00', 13.00),
    (2, 1, '2025-03-14', '17:30:00', 11.50),
    (3, 2, '2025-03-15', '16:45:00', 10.50),
    (4, 3, '2025-03-16', '20:00:00', 14.00),
    (5, 1, '2025-03-17', '19:15:00', 12.00),
    (6, 2, '2025-03-18', '21:30:00', 13.50);


SELECT s.show_id, t.name, t.city , m.Title, s.show_date, s.show_time, s.price
FROM Shows s
JOIN Theatres t ON s.theatre_id = t.theatre_id
JOIN Movies m ON s.movie_id = m.movie_id
Where m.title="The Lost City" and t.city="abc" and show_date=sysdate();