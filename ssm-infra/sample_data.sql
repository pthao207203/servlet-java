-- Dữ liệu sinh viên từ lớp IE303.P23.CNCL.1

TRUNCATE TABLE 
    ci_co,
    subjects,
    students,
    teachers,
    rooms,
    buildings
RESTART IDENTITY CASCADE;


INSERT INTO buildings (name, geom) VALUES
('Tòa A', NULL), ('Tòa B', NULL), ('Tòa C', NULL), ('Tòa E', NULL);

INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (1, 'A201', 2, 'Lý thuyết', 50, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (1, 'A202', 2, 'Thí nghiệm', 30, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (1, 'A203', 2, 'Lý thuyết', 50, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (2, 'B101', 1, 'Lý thuyết', 50, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (2, 'B102', 1, 'Thí nghiệm', 30, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (2, 'B301', 3, 'Lý thuyết', 50, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (2, 'B302', 3, 'Thí nghiệm', 30, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (3, 'C101', 1, 'Lý thuyết', 50, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (3, 'C201', 2, 'Lý thuyết', 30, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (3, 'C301', 3, 'Lý thuyết', 50, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (4, 'E201', 2, 'Lý thuyết', 50, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (4, 'E301', 3, 'Thí nghiệm', 30, NULL);
INSERT INTO rooms (building_id, name, floor, type, amount, geom) VALUES (4, 'E1101', 11, 'Lý thuyết', 30, NULL);

INSERT INTO teachers (name, password, msgv, gender, major) VALUES
('Thầy HTML', '101', '101', 'Nam', 'Thiết kế Web'),
('Thầy CSS', '102', '102', 'Nam', 'Thiết kế Web'),
('Thầy Java', '103', '103', 'Nam', 'Lập trình'),
('Thầy C++', '104', '104', 'Nam', 'Lập trình'),
('Thầy C#', '105', '105', 'Nam', 'Phát triển phần mềm'),
('Thầy Python', '106', '106', 'Nam', 'Khoa học dữ liệu'),
('Thầy SQL', '107', '107', 'Nam', 'Cơ sở dữ liệu'),
('Thầy R', '108', '108', 'Nam', 'Phân tích thống kê'),
('Thầy C', '109', '109', 'Nam', 'Hệ điều hành'),
('Thầy JS', '110', '110', 'Nam', 'Front-end');


INSERT INTO students (name, password, mssv, gender, major) VALUES ('Nguyễn Đức Đạt', '21520701', '21520701', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Phạm Bá Hoàng', '21520872', '21520872', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Tô Quốc Kiện', '21521029', '21521029', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Nguyễn Đỗ Đức Nguyên', '21521201', '21521201', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Lê Thanh Phong', '21521271', '21521271', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Dương Uy Quan', '21521323', '21521323', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Nguyễn Thành Trung', '21521595', '21521595', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Hồ Vũ An', '21521804', '21521804', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Trần Thanh Mẫn', '21522326', '21522326', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Đoàn Thị Tuyết Phương', '21522484', '21522484', 'Nữ', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Phan Thị Ngọc Ánh', '22520073', '22520073', 'Nữ', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Lê Đức Anh Duy', '22520315', '22520315', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Nguyễn Huỳnh Minh Kha', '22520598', '22520598', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Trần Lâm Ngọc Khanh', '22520653', '22520653', 'Nữ', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Ngô Tuấn Kiệt', '22520719', '22520719', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Phan Anh Kiệt', '22520723', '22520723', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Nguyễn Hồ Phi Long', '22520815', '22520815', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Lâm Tấn Nhật Minh', '22520863', '22520863', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Võ Uyển Nhi', '22521045', '22521045', 'Nữ', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Phạm Đinh Trang Nhung', '22521059', '22521059', 'Nữ', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Trần Thị Phương Thảo', '22521375', '22521375', 'Nữ', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Mai Võ Hoài Tiên', '22521468', '22521468', 'Nữ', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Nguyễn Thành Tính', '22521483', '22521483', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Nguyễn Hữu Trí', '22521520', '22521520', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Võ Tiến Trung', '22521574', '22521574', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Phan Nguyễn Anh Tuyền', '22521635', '22521635', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Lý Tuấn Văn', '22521650', '22521650', 'Nam', 'Kỹ thuật Thông tin');
INSERT INTO students (name, password, mssv, gender, major) VALUES ('Trần Nhật Vĩ', '22521659', '22521659', 'Nam', 'Kỹ thuật Thông tin');

INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (1, 'HTML', 1, ARRAY['2025-05-19 07:30:00']::TIMESTAMP[], 5, false, '2025-07-30', ARRAY[21520701,21520872,21521029,21521201,21521271]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (2, 'CSS', 2, ARRAY['2025-05-20 13:00:00']::TIMESTAMP[], 5, false, '2025-07-30', ARRAY[21521323,21521595,21521804,21522326]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (3, 'Java', 3, ARRAY['2025-05-21 07:30:00']::TIMESTAMP[], 5, true, '2025-08-15', ARRAY[21522484,22520073,22520315]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (1, 'C++', 4, ARRAY['2025-05-19 13:00:00']::TIMESTAMP[], 5, false, '2025-07-30', ARRAY[22520598,22520653,22520719]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (4, 'C#', 5, ARRAY['2025-05-22 07:30:00']::TIMESTAMP[], 5, true, '2025-08-15', ARRAY[22520723,22520815,22520863]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (2, 'Python', 4, ARRAY['2025-05-23 13:00:00']::TIMESTAMP[], 5, false, '2025-07-30', ARRAY[22521045,22521059]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (3, 'SQL', 5, ARRAY['2025-05-24 07:30:00']::TIMESTAMP[], 5, false, '2025-07-30', ARRAY[22521375,22521468,22521483]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (1, 'R', 6, ARRAY['2025-05-19 07:30:00']::TIMESTAMP[], 5, false, '2025-07-30', ARRAY[22521520,22521574,22521635]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (4, 'C', 7, ARRAY['2025-05-25 13:00:00']::TIMESTAMP[], 5, true, '2025-08-15', ARRAY[22521650,22521659]);
INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) VALUES (2, 'Javascript', 8, ARRAY['2025-05-26 07:30:00']::TIMESTAMP[], 5, false, '2025-07-30', ARRAY[21520701,21520872]);

INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (5, 1, ARRAY['2025-05-19 07:30:00'::timestamp], ARRAY['2025-05-19 09:30:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (6, 2, ARRAY['2025-05-20 08:00:00'::timestamp], ARRAY['2025-05-20 10:00:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (8, 3, ARRAY['2025-05-21 07:30:00'::timestamp], ARRAY['2025-05-21 09:30:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (2, 2, ARRAY['2025-05-19 13:00:00'::timestamp], ARRAY['2025-05-19 15:00:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (1, 4, ARRAY['2025-05-22 07:30:00'::timestamp], ARRAY['2025-05-22 09:30:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (3, 3, ARRAY['2025-05-23 08:00:00'::timestamp], ARRAY['2025-05-23 10:00:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (9, 2, ARRAY['2025-05-24 07:30:00'::timestamp], ARRAY['2025-05-24 09:30:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (10, 4, ARRAY['2025-05-25 13:00:00'::timestamp], ARRAY['2025-05-25 15:00:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (16, 3, ARRAY['2025-05-26 07:30:00'::timestamp], ARRAY['2025-05-26 09:30:00'::timestamp], 1);
INSERT INTO ci_co (student_id, room_id, checkin_time, checkout_time, status) VALUES (14, 1, ARRAY['2025-05-19 13:00:00'::timestamp], ARRAY['2025-05-19 15:00:00'::timestamp], 1);
