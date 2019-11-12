CREATE TABLE dressings (
  dressingID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dressingName varchar(45) NOT NULL,
  drainageRequirement varchar(45) NOT NULL,
  thicknessRequirement varchar(45) NOT NULL,
  debridementRequired varchar(45) NOT NULL,
  frequencyAllowed varchar(45) NOT NULL
);

INSERT INTO dressings (dressingType,drainageRequirement,thicknessRequirement,debridementRequired,frequencyAllowed)
VALUES
("Calcium Alginate","moderate to heavy","full thickness","yes","once a day"),
("Silver Alginate","moderate to heavy","full thickness","yes","once a day"),
("ABD Pad","moderate to heavy","full thickness","yes","once a day"),
("Xtrasorb","moderate to heavy","full thickness","yes","once a day"),
("Silicone Foam non border","moderate to heavy","full thickness","yes","every third day"),
("Silicone foam border","moderate to heavy","full thickness","yes","every third day"),
("Foam non border","moderate to heavy","full thickness","yes","every third day"),
("Foam border","moderate to heavy","full thickness","yes","every third day"),
("Silver Foam non border","moderate to heavy","full thickness","yes","every third day"),
("Silver foam border","moderate to heavy","full thickness","yes","every third day"),
("Hydrogel Wound filler","none to small","full thickness","yes","once a day"),
("Hydrogel Sheet","none to small","full thickness","yes","once a day"),
("Hydrogel Gauze","none to small","full thickness","yes","once a day"),
("Medihoney Hydrogel sheet","none to small","full thickness","yes","once a day"),
("Gauze pads","any","any","yes","once a day"),
("Bulky roll gauze","any","any","yes","once a day"),
("Paper Tape","any","any","yes","based on wound size"),
("Medipore Tape","any","any","yes","based on wound size"),
("silk tape","any","any","yes","based on wound size"),
("Silicone Tape","any","any","yes","based on wound size"),
("Conforming roll gauze / Kling","any","any","yes","once a day"),
("Promogran Prisma","small to moderate","full thickness","yes","once a day"),
("Promogran","small to moderate","full thickness","yes","once a day"),
("Hydrocolloid","small to moderate","full thickness","yes","every third day");
