INSERT INTO sender (username, password)
VALUES ('user1', '$2a$04$DIfVsvfdxCvG/gAgWIEfAOP0Kx.lzZuNP30lClWU3FMaLo3615KTe'),
       ('user2', '$2a$04$Gf.nDfCkIg4Qm28M.V3lb.eAFSZgx6ikFPZMdfFORXzNBx5SOKNsa'),
       ('user3', '$2a$04$MdlXzYIKj.3li0M8QDNfwejDA2b091x4M33H5q/voHgxQ8NRZ57P6');

INSERT INTO message(sender_id, message_datetime, message)
VALUES (1, '2021-11-30 10:00:00', 'user1message1'),
       (1, '2021-11-30 10:00:01', 'user1message2'),
       (1, '2021-11-30 10:00:02', 'user1message3'),
       (1, '2021-11-30 10:00:03', 'user1message4'),
       (1, '2021-11-30 10:00:04', 'user1message5'),
       (1, '2021-11-30 10:00:05', 'user1message6'),
       (1, '2021-11-30 10:00:06', 'user1message7'),
       (1, '2021-11-30 10:00:07', 'user1message8'),
       (1, '2021-11-30 10:00:08', 'user1message9'),
       (1, '2021-11-30 10:00:09', 'user1message10'),
       (1, '2021-11-30 10:00:10', 'user1message11'),
       (1, '2021-11-30 10:00:11', 'user1message12'),
       (1, '2021-11-30 10:00:12', 'user1message13'),
       (2, '2021-11-30 10:00:00', 'user2message1'),
       (2, '2021-11-30 10:01:00', 'user2message2'),
       (2, '2021-11-30 10:02:00', 'user2message3'),
       (2, '2021-11-30 10:03:00', 'user2message4'),
       (2, '2021-11-30 10:03:00', 'user2message5'),
       (2, '2021-11-30 10:04:00', 'user2message6'),
       (2, '2021-11-30 10:05:00', 'user2message7'),
       (2, '2021-11-30 10:06:00', 'user2message8'),
       (2, '2021-11-30 10:07:00', 'user2message9'),
       (2, '2021-11-30 10:08:00', 'user2message10'),
       (2, '2021-11-30 10:09:00', 'user2message11'),
       (2, '2021-11-30 10:10:00', 'user2message12'),
       (2, '2021-11-30 10:11:00', 'user2message13'),
       (2, '2021-11-30 10:12:00', 'user2message14'),
       (2, '2021-11-30 10:13:00', 'user2message15'),
       (3, '2021-11-30 11:00:00', 'user3message1'),
       (3, '2021-11-30 11:00:01', 'user3message2'),
       (3, '2021-11-30 11:00:02', 'user3message3'),
       (3, '2021-11-30 11:00:03', 'user3message4');
