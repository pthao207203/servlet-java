
-- Tạo schema mẫu cho hệ thống SSM
CREATE EXTENSION IF NOT EXISTS postgis;

CREATE TABLE buildings (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    geom GEOMETRY(POLYGONZ, 4326)
);

CREATE TABLE rooms (
    id SERIAL PRIMARY KEY,
    building_id INT REFERENCES buildings(id),
    name VARCHAR(50),
    floor INT,
    type VARCHAR(50),
	amount INT,
    geom GEOMETRY(POLYGONZ, 4326)
);

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    password TEXT NOT NULL,          
    mssv VARCHAR(20) UNIQUE,      
    gender VARCHAR(10),
    major TEXT
);

CREATE TABLE teachers (
    id SERIAL PRIMARY KEY,
    name TEXT,
    password TEXT NOT NULL,          
    msgv VARCHAR(20) UNIQUE,      
    gender VARCHAR(10),
    major TEXT
);

CREATE TABLE subjects (
    id SERIAL PRIMARY KEY,                   
    room_id INT REFERENCES rooms(id),       
    subject_name TEXT,                       
    teacher_id INT REFERENCES teachers(id), 

    start_times TIMESTAMP[],                 
    periods_per_day INT,                     
    week_pattern BOOLEAN,                  
    end_date DATE,    
	student_ids INT[]   
);


CREATE TABLE ci_co (
    id SERIAL PRIMARY KEY,
    student_id INT REFERENCES students(id),             
    room_id INT REFERENCES rooms(id),                    
    checkin_time TIMESTAMP[],                            
    checkout_time TIMESTAMP[],                            
    status INT                                     
);


