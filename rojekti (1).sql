-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 13.12.2016 klo 10:07
-- Palvelimen versio: 5.5.50-MariaDB
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rojekti`
--

-- --------------------------------------------------------

--
-- Rakenne taululle `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `CatID` int(11) NOT NULL,
  `Tag` char(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `category`
--

INSERT INTO `category` (`CatID`, `Tag`) VALUES
(1, 'Math'),
(2, 'Java');

-- --------------------------------------------------------

--
-- Rakenne taululle `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `ComID` int(11) NOT NULL,
  `Content` text,
  `Comment_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Com_UserID` int(11) DEFAULT NULL,
  `Likecount` int(11) DEFAULT NULL,
  `postid` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `comment`
--

INSERT INTO `comment` (`ComID`, `Content`, `Comment_timestamp`, `Com_UserID`, `Likecount`, `postid`) VALUES
(1, 'Okay lets figure this out.', '2016-12-04 14:35:02', 9, 44, 2),
(2, 'Lets interpret this one first.', '2016-12-04 14:34:53', 9, 50, 1),
(3, 'moikkamoi en tiedä vastausta ', '2016-12-12 14:18:16', 9, 0, 18),
(4, 'padappadadaaa', '2016-12-12 16:08:33', 9, 0, 18),
(5, 'moikka', '2016-12-12 16:17:12', 9, 0, 17),
(6, 'moikka', '2016-12-12 16:17:14', 9, 0, 17),
(7, 'moikka', '2016-12-12 16:17:14', 9, 0, 17),
(8, 'moikka', '2016-12-12 16:17:15', 9, 0, 17),
(9, 'moikka', '2016-12-12 16:17:15', 9, 0, 17);

-- --------------------------------------------------------

--
-- Rakenne taululle `comment_has_media`
--

CREATE TABLE IF NOT EXISTS `comment_has_media` (
  `commenthasmedia` int(11) NOT NULL,
  `Comment` int(11) DEFAULT NULL,
  `Media` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Rakenne taululle `media`
--

CREATE TABLE IF NOT EXISTS `media` (
  `MediaID` int(11) NOT NULL,
  `URL` varchar(1000) DEFAULT NULL,
  `Media_type` char(25) DEFAULT NULL,
  `PATH` text NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `media`
--

INSERT INTO `media` (`MediaID`, `URL`, `Media_type`, `PATH`) VALUES
(6, '/var/www/html/project/5', 'picture', 'Penguins.jpg'),
(7, '/var/www/html/project/6', 'picture', 'Hydrangeas.jpg'),
(8, '/var/www/html/project/7', 'picture', 'Koala.jpg'),
(9, '/var/www/html/project/8', 'picture', 'Tulips.jpg'),
(10, '/var/www/html/project/9', 'picture', 'Jellyfish.jpg'),
(11, '/var/www/html/project/10', 'picture', 'Lighthouse.jpg'),
(12, '/var/www/html/project/11', 'picture', 'Chrysanthemum.jpg'),
(13, '/var/www/html/project/12', 'picture', '68738877-cowboy-wallpapers.jpg'),
(14, '/var/www/html/project/13', 'picture', '68738877-cowboy-wallpapers.jpg'),
(15, '/var/www/html/project/14', 'picture', 'bullshit_everywhere-e1345505471862.jpeg'),
(16, '/var/www/html/project/15', 'picture', 'bullshit_everywhere-e1345505471862.jpeg'),
(17, '/var/www/html/project/16', 'picture', 'bullshit_everywhere-e1345505471862.jpeg'),
(18, 'http://10.114.32.48/project/17/', 'picture', 'bullshit_everywhere-e1345505471862.jpeg'),
(19, 'http://10.114.32.48/project/18/', 'picture', 'huuhkajalogo.png'),
(20, 'http://10.114.32.48/project/19/', 'picture', 'html.png'),
(21, 'http://10.114.32.48/project/20/', 'picture', 'database.png'),
(22, 'http://10.114.32.48/project/21/', 'picture', 'bullshit_everywhere-e1345505471862.jpeg');

-- --------------------------------------------------------

--
-- Rakenne taululle `post_has_category`
--

CREATE TABLE IF NOT EXISTS `post_has_category` (
  `posthascategory` int(11) NOT NULL,
  `Post` int(11) DEFAULT NULL,
  `Category` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `post_has_category`
--

INSERT INTO `post_has_category` (`posthascategory`, `Post`, `Category`) VALUES
(1, 4, 1),
(2, 5, 1),
(3, 6, 2),
(4, 7, 2),
(5, 8, 2),
(6, 9, 2),
(7, 10, 1),
(8, 11, 1),
(9, 12, 1),
(10, 13, 1),
(11, 14, 1),
(12, 15, 1),
(13, 16, 1),
(14, 17, 1),
(15, 18, 2),
(16, 19, 2),
(17, 20, 2),
(18, 21, 2);

-- --------------------------------------------------------

--
-- Rakenne taululle `post_has_media`
--

CREATE TABLE IF NOT EXISTS `post_has_media` (
  `posthasmedia` int(11) NOT NULL,
  `PostMed` int(11) DEFAULT NULL,
  `MedPost` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `post_has_media`
--

INSERT INTO `post_has_media` (`posthasmedia`, `PostMed`, `MedPost`) VALUES
(2, 5, 6),
(3, 6, 7),
(4, 7, 8),
(5, 8, 9),
(6, 9, 10),
(7, 10, 11),
(8, 11, 12),
(9, 12, 13),
(10, 16, 17),
(11, 17, 18),
(12, 18, 19),
(13, 19, 20),
(14, 20, 21),
(15, 21, 22);

-- --------------------------------------------------------

--
-- Rakenne taululle `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL,
  `Username` char(25) NOT NULL DEFAULT '',
  `Passwd` char(15) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `user`
--

INSERT INTO `user` (`ID`, `Username`, `Passwd`, `Email`) VALUES
(1, 'Juh Lii', 'juhlii1234', 'juh.lii@hotmail.com'),
(2, 'KantZiiDokata', 'moimoi', 'kant.zii@gmail.fi'),
(3, 'test', NULL, 'Test@ttt.yy'),
(4, 'raikku', NULL, 'villi.hevonen@vermo.com'),
(5, 'Seppo', NULL, 'sepi.sepalus@seppo.fi'),
(6, 'heikki helamies', NULL, 'hekka.heltsi@helevetti.fi'),
(7, 'heikki helamies', 'pölölöö', 'hekka.heltsi@helevetti.fi'),
(8, 'Kyösti', 'mersu', 'keke.keijoantero@kyosti.fi'),
(9, 'moi', 'moi', 'moi@moi.com'),
(10, 'birgitta', 'hee', 'birgitta.b@berberi.bb'),
(11, 'risujemmaaja', 'perkele', 'muutama@risu.uskojo'),
(12, 'voivoi', 'pölölöö', 'hajotus.maximus@prkl.bing'),
(13, 'hötömölö', 'html', 'html.html@html.fi'),
(14, 'roope', 'roope', 'rrviol@gmail.com');

-- --------------------------------------------------------

--
-- Rakenne taululle `user_post`
--

CREATE TABLE IF NOT EXISTS `user_post` (
  `PostID` int(11) NOT NULL,
  `Content` text,
  `Post_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Title` char(100) DEFAULT NULL,
  `Post_UserID` int(11) DEFAULT NULL,
  `Likes` int(11) DEFAULT NULL,
  `url` text
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Vedos taulusta `user_post`
--

INSERT INTO `user_post` (`PostID`, `Content`, `Post_timestamp`, `Title`, `Post_UserID`, `Likes`, `url`) VALUES
(1, 'First lets use this as an example.', '2016-11-29 14:44:49', 'Lets try to figure this out.', 9, 0, ''),
(2, 'Then lets use this as an example.', '2016-11-29 14:46:43', 'What the ....?', 1, 0, ''),
(3, 'jooko', '2016-12-05 05:34:10', 'toimi', 9, 0, 'single_post.html'),
(4, 'Try to figure it out', '2016-12-09 14:09:25', 'Perkele', 9, 0, 'single_post.html'),
(5, 'These penquins are animals', '2016-12-12 07:24:05', 'Ghello', 9, 0, 'single_post.html'),
(6, 'MikÃ¤ on tÃ¤mÃ¤ kaunis kukkanen?', '2016-12-12 07:27:31', 'no minÃ¤pÃ¤ kysyn', 9, 0, 'single_post.html'),
(7, 'kysyppÃ¤ joku toine', '2016-12-12 07:28:16', '`mikÃ¤ animal?', 9, 0, 'single_post.html'),
(8, 'MissÃ¤ on tuo sadepisara?', '2016-12-12 07:28:49', 'tarvitsen apua', 9, 0, 'single_post.html'),
(9, 'dindindiii', '2016-12-12 07:29:18', 'meduusani ja minÃ¤', 9, 0, 'single_post.html'),
(10, 'missÃ¤ on horisontti?', '2016-12-12 07:34:07', 'kertokaa', 9, 0, 'single_post.html'),
(11, 'TÃ¤ssÃ¤ on kaunis kukkanen', '2016-12-12 07:36:04', 'Montako risua?', 9, 0, 'single_post.html'),
(12, 'padappadaaa', '2016-12-12 09:43:32', 'PÃ?Ã?Ã?', 1, 0, 'single_post.html'),
(13, 'PÃ?Ã?Ã? prkl', '2016-12-12 09:44:37', 'padappadaaa', 1, 0, 'single_post.html'),
(14, 'PÃ?Ã?Ã? prkl', '2016-12-12 09:44:58', 'padappadaaa', 1, 0, 'single_post.html'),
(15, 'PÃ?Ã?Ã? prkl', '2016-12-12 09:45:28', 'padappadaaa', 1, 0, 'single_post.html'),
(16, 'toimiks', '2016-12-12 11:52:20', 'Mo', 9, 0, 'single_post.html'),
(17, 'Toimi Toimi', '2016-12-12 11:56:06', 'Joko nyt', 9, 0, 'single_post.html'),
(18, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In vitae accumsan lacus. Quisque vel orci ut risus aliquet posuere. Nullam elit arcu, hendrerit a neque sit amet, pulvinar vestibulum enim. Donec convallis lorem a lobortis congue. Donec at leo id justo imperdiet venenatis. In efficitur, mauris non gravida posuere, odio purus tristique enim, semper efficitur nunc ipsum sed odio. Nullam in magna et urna posuere mattis. Donec aliquet maximus ante, ut vulputate libero condimentum eget. Duis id sapien rhoncus libero facilisis venenatis id in turpis. Nam quam nunc, posuere vitae mattis sit amet, gravida at sem. Morbi posuere volutpat mi. Integer aliquam nibh ullamcorper arcu fermentum, non mattis orci efficitur. Morbi pretium placerat lacus.', '2016-12-12 12:04:08', 'Lorem ipsum dolor sit amet', 9, 0, 'single_post.html'),
(19, 'Ottaen huomioon oman tilanteensa, voi vain todeta, ettÃ¤ tiedon valtatie, joka tosin jossain mÃ¤Ã¤rin on vanhentunut kÃ¤site, jÃ¤rkeistÃ¤Ã¤ kÃ¤sitystÃ¤mme kyseisestÃ¤ asiakokonaisuudesta, mihin tavallaan liittyy myÃ¶s asianosaisiin kohdistuvia ongelmia.', '2016-12-12 16:39:17', 'Lorem ipsumia', 9, 0, 'single_post.html'),
(20, 'This is our database.', '2016-12-13 08:12:53', 'It works', 9, 0, 'single_post.html'),
(21, 'jeejee', '2016-12-13 09:30:27', 'this is fun', 1, 0, 'single_post.html');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CatID`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`ComID`),
  ADD KEY `Com_UserID` (`Com_UserID`),
  ADD KEY `postid` (`postid`);

--
-- Indexes for table `comment_has_media`
--
ALTER TABLE `comment_has_media`
  ADD PRIMARY KEY (`commenthasmedia`),
  ADD KEY `Comment` (`Comment`),
  ADD KEY `Media` (`Media`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`MediaID`);

--
-- Indexes for table `post_has_category`
--
ALTER TABLE `post_has_category`
  ADD PRIMARY KEY (`posthascategory`),
  ADD KEY `Post` (`Post`),
  ADD KEY `Category` (`Category`);

--
-- Indexes for table `post_has_media`
--
ALTER TABLE `post_has_media`
  ADD PRIMARY KEY (`posthasmedia`),
  ADD KEY `PostMed` (`PostMed`),
  ADD KEY `MedPost` (`MedPost`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user_post`
--
ALTER TABLE `user_post`
  ADD PRIMARY KEY (`PostID`),
  ADD KEY `Post_UserID` (`Post_UserID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `CatID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `ComID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `comment_has_media`
--
ALTER TABLE `comment_has_media`
  MODIFY `commenthasmedia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
  MODIFY `MediaID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `post_has_category`
--
ALTER TABLE `post_has_category`
  MODIFY `posthascategory` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `post_has_media`
--
ALTER TABLE `post_has_media`
  MODIFY `posthasmedia` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `user_post`
--
ALTER TABLE `user_post`
  MODIFY `PostID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- Rajoitteet vedostauluille
--

--
-- Rajoitteet taululle `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`postid`) REFERENCES `user_post` (`PostID`),
  ADD CONSTRAINT `Com_UserID` FOREIGN KEY (`Com_UserID`) REFERENCES `user` (`ID`);

--
-- Rajoitteet taululle `comment_has_media`
--
ALTER TABLE `comment_has_media`
  ADD CONSTRAINT `Comment` FOREIGN KEY (`Comment`) REFERENCES `comment` (`ComID`),
  ADD CONSTRAINT `Media` FOREIGN KEY (`Media`) REFERENCES `media` (`MediaID`);

--
-- Rajoitteet taululle `post_has_category`
--
ALTER TABLE `post_has_category`
  ADD CONSTRAINT `Category` FOREIGN KEY (`Category`) REFERENCES `category` (`CatID`),
  ADD CONSTRAINT `Post` FOREIGN KEY (`Post`) REFERENCES `user_post` (`PostID`);

--
-- Rajoitteet taululle `post_has_media`
--
ALTER TABLE `post_has_media`
  ADD CONSTRAINT `MedPost` FOREIGN KEY (`MedPost`) REFERENCES `media` (`MediaID`),
  ADD CONSTRAINT `PostMed` FOREIGN KEY (`PostMed`) REFERENCES `user_post` (`PostID`);

--
-- Rajoitteet taululle `user_post`
--
ALTER TABLE `user_post`
  ADD CONSTRAINT `user_post_ibfk_1` FOREIGN KEY (`Post_UserID`) REFERENCES `user` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
