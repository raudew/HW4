drop table student;
CREATE TABLE student (studentID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 444111110, INCREMENT BY 1),
   firstName varchar (25) NOT NULL,
   lastName varchar (25) NOT NULL,
   Major char (4),
   Email varchar (30) NOT NULL,
   PhoneNumber char (11),
   birthDate Date NOT NULL,
   Address varchar (100) NOT NULL,
   zipCode char(5) NOT NULL,
   PRIMARY KEY (studentID) );
  
  INSERT INTO student ( firstName,lastName,Major,Email,PhoneNumber,birthDate,Address,zipCode)
VALUES
( 'Jacob','Smith','INSY','jacob.smith@mavs.uta.edu','9129219434','4/9/1985','99 Kingston Street','31435'),
( 'John','Stevenson','MANA','john.stevenson@mavs.uta.edu','Null','5/10/1988','100 Main Street','31411'),
( 'George','Heintz','INSY','george.heintz@mavs.uta.edu','9129213454','10/10/1974','1200 Abercorn Street','31419'),
( 'Frank','Jones','FINA','frank.jones@mavs.uta.edu','9125919434','9/9/1970','100 Main Street','31411'),
( 'Jean','Smith','ECON','jean.smith@mavs.uta.edu','9129219434','2/9/1970','100 Main Street','31411'),
( 'John','Woo','MANA','josh.woo@mavs.uta.edu','7075989434','2/9/1970','555 Franklin Street','31411');
 SELECT * FROM student;
 