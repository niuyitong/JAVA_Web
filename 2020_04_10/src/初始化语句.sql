CREATE TABLE dictionaries (
    id INT PRIMARY KEY AUTO_INCREMENT,
    en VARCHAR(50) NOT NULL UNIQUE,
    zh VARCHAR(100) NOT NULL,
    sentence TEXT NOT NULL
);

INSERT INTO dictionaries (en, zh, sentence) VALUES
    ("word", "词", "I have a word."),
    ("bit", "比特", "I have learned IT skill in Bit.");