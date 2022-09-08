insert into plan(name, validity, price, discount, final_price)
               values('MONTHLY', 30, 1500, 0, 1500);
insert into plan(name, validity, price, discount, final_price)
               values('QUARTERLY', 90, 4500, 500, 4000);
insert into plan(name, validity, price, discount, final_price)
               values('HALF_YEARLY', 180, 9000, 2000, 7000);
insert into plan(name, validity, price, discount, final_price)
               values('YEARLY', 365, 18000, 6000, 12000);

-- plain password=abc123
insert into login_user(created_date,password, role, username)
 values(now(), '{bcrypt}$2a$10$vTBNLad1xNnjYIO1s.hoVOsH9ATZ4fmvv8YByvuBdTu0HDGWi8KTe', 'ADMIN', 'admin');

