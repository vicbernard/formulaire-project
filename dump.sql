-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 14 Janvier 2016 à 17:55
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `ID` int(11) NOT NULL,
  `AGE` int(11) DEFAULT NULL,
  `DATEINSCRIPTION` date DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `MAIL` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PWD` varchar(255) DEFAULT NULL,
  `SEX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `customer`
--

INSERT INTO `customer` (`ID`, `AGE`, `DATEINSCRIPTION`, `FIRSTNAME`, `MAIL`, `NAME`, `PWD`, `SEX`) VALUES
(1, 45, '2016-01-01', 'test', 'test@test.fr', 'test', 'test', 'm'),
(1051, 0, NULL, 'test', 'test@test.fr', 'nameTest', 'coucou', NULL),
(1052, 0, NULL, 'test', 'test2@test.fr', NULL, 'coucou', NULL),
(1101, 0, NULL, 'test', 'test@test.fr', 'nameTest', 'coucou', NULL),
(1102, 0, NULL, 'test', 'test2@test.fr', NULL, 'coucou', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `customerold`
--

CREATE TABLE IF NOT EXISTS `customerold` (
  `ID` bigint(20) NOT NULL,
  `FISTNAME` varchar(255) DEFAULT NULL,
  `MAIL` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PWD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `formulairereponses`
--

CREATE TABLE IF NOT EXISTS `formulairereponses` (
  `IDFORMULAIRE` int(11) NOT NULL,
  `CUSTOMERBYIDUSER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDFORMULAIRE`),
  KEY `FK_FORMULAIREREPONSES_CUSTOMERBYIDUSER_ID` (`CUSTOMERBYIDUSER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `formulairereponses`
--

INSERT INTO `formulairereponses` (`IDFORMULAIRE`, `CUSTOMERBYIDUSER_ID`) VALUES
(1204, 1),
(1207, 1),
(1210, 1),
(1213, 1),
(1216, 1),
(1219, 1),
(1222, 1),
(1225, 1),
(1228, 1),
(1231, 1),
(1234, 1),
(1237, 1),
(1240, 1),
(1243, 1),
(1246, 1),
(1249, 1),
(1252, 1),
(1255, 1),
(1258, 1),
(1261, 1),
(1267, 1),
(1270, 1),
(1273, 1),
(1276, 1),
(1279, 1),
(1282, 1),
(1285, 1),
(1288, 1),
(1291, 1),
(1294, 1),
(1297, 1),
(1300, 1),
(1303, 1),
(1306, 1),
(1309, 1),
(1312, 1),
(1315, 1),
(1318, 1),
(1321, 1),
(1324, 1),
(1327, 1),
(1330, 1),
(1333, 1),
(1336, 1),
(1339, 1),
(1342, 1),
(1345, 1),
(1348, 1),
(1351, 1),
(1354, 1),
(1361, 1),
(1365, 1),
(1369, 1),
(1373, 1),
(1377, 1),
(1381, 1),
(1385, 1),
(1389, 1),
(1393, 1),
(1397, 1),
(1401, 1),
(1405, 1),
(1409, 1),
(1413, 1),
(1417, 1),
(1421, 1),
(1425, 1),
(1429, 1),
(1433, 1),
(1437, 1);

-- --------------------------------------------------------

--
-- Structure de la table `paramtypequestion`
--

CREATE TABLE IF NOT EXISTS `paramtypequestion` (
  `IDTYPE` int(11) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDTYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `paramtypequestion`
--

INSERT INTO `paramtypequestion` (`IDTYPE`, `LIBELLE`) VALUES
(1, 'Oui/Non'),
(2, 'Date'),
(3, 'Ouverte');

-- --------------------------------------------------------

--
-- Structure de la table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `IDQUESTION` int(11) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `PARAMTYPEQUESTIONBYIDTYPE_IDTYPE` int(11) DEFAULT NULL,
  `QUESTIONNAIREBYIDQUESTIONNAIRE_IDQUESTIONNAIRE` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDQUESTION`),
  KEY `QSTIONQESTIONNAIREBYIDQUESTIONNAIREIDQUESTIONNAIRE` (`QUESTIONNAIREBYIDQUESTIONNAIRE_IDQUESTIONNAIRE`),
  KEY `FK_QUESTION_PARAMTYPEQUESTIONBYIDTYPE_IDTYPE` (`PARAMTYPEQUESTIONBYIDTYPE_IDTYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `question`
--

INSERT INTO `question` (`IDQUESTION`, `LIBELLE`, `PARAMTYPEQUESTIONBYIDTYPE_IDTYPE`, `QUESTIONNAIREBYIDQUESTIONNAIRE_IDQUESTIONNAIRE`) VALUES
(1202, 'Etes vous un homme ?', 1, 1201),
(1203, 'Aimez vous les huitres ?', 1, 1201),
(1265, 'Avez vous plus de 30 ans ?', 1, 1264),
(1266, 'Avez vous un chat ?', 1, 1264),
(1358, 'Avez vous plus de 30 ans ?', 1, 1357),
(1359, 'Etes vous une femme ?', 1, 1357),
(1360, 'Achetez vous bio régulièrement ?', 1, 1357);

-- --------------------------------------------------------

--
-- Structure de la table `questionnaire`
--

CREATE TABLE IF NOT EXISTS `questionnaire` (
  `IDQUESTIONNAIRE` int(11) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `PRIVE` tinyint(1) DEFAULT '0',
  `CUSTOMERBYIDUSER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDQUESTIONNAIRE`),
  KEY `FK_QUESTIONNAIRE_CUSTOMERBYIDUSER_ID` (`CUSTOMERBYIDUSER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `questionnaire`
--

INSERT INTO `questionnaire` (`IDQUESTIONNAIRE`, `LIBELLE`, `PRIVE`, `CUSTOMERBYIDUSER_ID`) VALUES
(1201, 'Sondage sur les gens aimant les huitres', 0, 1),
(1264, 'Sondage les gens ayant un chat ?', 0, 1),
(1357, 'Sondage personnes achetant bio', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `reponse`
--

CREATE TABLE IF NOT EXISTS `reponse` (
  `IDREPONSE` int(11) NOT NULL,
  `REPONSE` varchar(255) DEFAULT NULL,
  `FORMULAIREREPONSESBYIDFORMULAIRE_IDFORMULAIRE` int(11) DEFAULT NULL,
  `QUESTIONBYIDQUESTION_IDQUESTION` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDREPONSE`),
  KEY `FK_REPONSE_QUESTIONBYIDQUESTION_IDQUESTION` (`QUESTIONBYIDQUESTION_IDQUESTION`),
  KEY `RPONSEFORMULAIREREPONSESBYIDFORMULAIREIDFORMULAIRE` (`FORMULAIREREPONSESBYIDFORMULAIRE_IDFORMULAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `reponse`
--

INSERT INTO `reponse` (`IDREPONSE`, `REPONSE`, `FORMULAIREREPONSESBYIDFORMULAIRE_IDFORMULAIRE`, `QUESTIONBYIDQUESTION_IDQUESTION`) VALUES
(1205, 'Non', 1204, 1202),
(1206, 'Non', 1204, 1203),
(1208, 'Oui', 1207, 1202),
(1209, 'Non', 1207, 1203),
(1211, 'Non', 1210, 1202),
(1212, 'Oui', 1210, 1203),
(1214, 'Non', 1213, 1202),
(1215, 'Non', 1213, 1203),
(1217, 'Non', 1216, 1202),
(1218, 'Non', 1216, 1203),
(1220, 'Non', 1219, 1202),
(1221, 'Non', 1219, 1203),
(1223, 'Oui', 1222, 1202),
(1224, 'Oui', 1222, 1203),
(1226, 'Oui', 1225, 1202),
(1227, 'Oui', 1225, 1203),
(1229, 'Oui', 1228, 1202),
(1230, 'Oui', 1228, 1203),
(1232, 'Oui', 1231, 1202),
(1233, 'Oui', 1231, 1203),
(1235, 'Non', 1234, 1202),
(1236, 'Oui', 1234, 1203),
(1238, 'Non', 1237, 1202),
(1239, 'Non', 1237, 1203),
(1241, 'Non', 1240, 1202),
(1242, 'Oui', 1240, 1203),
(1244, 'Non', 1243, 1202),
(1245, 'Oui', 1243, 1203),
(1247, 'Non', 1246, 1202),
(1248, 'Non', 1246, 1203),
(1250, 'Non', 1249, 1202),
(1251, 'Non', 1249, 1203),
(1253, 'Oui', 1252, 1202),
(1254, 'Oui', 1252, 1203),
(1256, 'Oui', 1255, 1202),
(1257, 'Non', 1255, 1203),
(1259, 'Non', 1258, 1202),
(1260, 'Non', 1258, 1203),
(1262, 'Oui', 1261, 1202),
(1263, 'Non', 1261, 1203),
(1268, 'Oui', 1267, 1265),
(1269, 'Oui', 1267, 1266),
(1271, 'Oui', 1270, 1265),
(1272, 'Oui', 1270, 1266),
(1274, 'Oui', 1273, 1265),
(1275, 'Non', 1273, 1266),
(1277, 'Oui', 1276, 1265),
(1278, 'Non', 1276, 1266),
(1280, 'Non', 1279, 1265),
(1281, 'Non', 1279, 1266),
(1283, 'Non', 1282, 1265),
(1284, 'Oui', 1282, 1266),
(1286, 'Oui', 1285, 1265),
(1287, 'Non', 1285, 1266),
(1289, 'Oui', 1288, 1265),
(1290, 'Oui', 1288, 1266),
(1292, 'Non', 1291, 1265),
(1293, 'Non', 1291, 1266),
(1295, 'Oui', 1294, 1265),
(1296, 'Oui', 1294, 1266),
(1298, 'Oui', 1297, 1265),
(1299, 'Oui', 1297, 1266),
(1301, 'Oui', 1300, 1265),
(1302, 'Non', 1300, 1266),
(1304, 'Non', 1303, 1265),
(1305, 'Non', 1303, 1266),
(1307, 'Oui', 1306, 1265),
(1308, 'Oui', 1306, 1266),
(1310, 'Non', 1309, 1265),
(1311, 'Non', 1309, 1266),
(1313, 'Oui', 1312, 1265),
(1314, 'Oui', 1312, 1266),
(1316, 'Oui', 1315, 1265),
(1317, 'Non', 1315, 1266),
(1319, 'Oui', 1318, 1265),
(1320, 'Non', 1318, 1266),
(1322, 'Oui', 1321, 1265),
(1323, 'Non', 1321, 1266),
(1325, 'Oui', 1324, 1265),
(1326, 'Oui', 1324, 1266),
(1328, 'Non', 1327, 1265),
(1329, 'Oui', 1327, 1266),
(1331, 'Oui', 1330, 1265),
(1332, 'Oui', 1330, 1266),
(1334, 'Oui', 1333, 1265),
(1335, 'Oui', 1333, 1266),
(1337, 'Non', 1336, 1265),
(1338, 'Non', 1336, 1266),
(1340, 'Non', 1339, 1265),
(1341, 'Oui', 1339, 1266),
(1343, 'Oui', 1342, 1265),
(1344, 'Oui', 1342, 1266),
(1346, 'Non', 1345, 1265),
(1347, 'Non', 1345, 1266),
(1349, 'Non', 1348, 1265),
(1350, 'Non', 1348, 1266),
(1352, 'Oui', 1351, 1265),
(1353, 'Oui', 1351, 1266),
(1355, 'Non', 1354, 1265),
(1356, 'Oui', 1354, 1266),
(1362, 'Oui', 1361, 1358),
(1363, 'Oui', 1361, 1359),
(1364, 'Non', 1361, 1360),
(1366, 'Oui', 1365, 1358),
(1367, 'Oui', 1365, 1359),
(1368, 'Oui', 1365, 1360),
(1370, 'Oui', 1369, 1358),
(1371, 'Non', 1369, 1359),
(1372, 'Oui', 1369, 1360),
(1374, 'Non', 1373, 1358),
(1375, 'Non', 1373, 1359),
(1376, 'Non', 1373, 1360),
(1378, 'Non', 1377, 1358),
(1379, 'Non', 1377, 1359),
(1380, 'Oui', 1377, 1360),
(1382, 'Oui', 1381, 1358),
(1383, 'Non', 1381, 1359),
(1384, 'Oui', 1381, 1360),
(1386, 'Oui', 1385, 1358),
(1387, 'Oui', 1385, 1359),
(1388, 'Oui', 1385, 1360),
(1390, 'Oui', 1389, 1358),
(1391, 'Non', 1389, 1359),
(1392, 'Oui', 1389, 1360),
(1394, 'Non', 1393, 1358),
(1395, 'Oui', 1393, 1359),
(1396, 'Non', 1393, 1360),
(1398, 'Oui', 1397, 1358),
(1399, 'Non', 1397, 1359),
(1400, 'Non', 1397, 1360),
(1402, 'Non', 1401, 1358),
(1403, 'Oui', 1401, 1359),
(1404, 'Oui', 1401, 1360),
(1406, 'Oui', 1405, 1358),
(1407, 'Oui', 1405, 1359),
(1408, 'Oui', 1405, 1360),
(1410, 'Non', 1409, 1358),
(1411, 'Oui', 1409, 1359),
(1412, 'Oui', 1409, 1360),
(1414, 'Oui', 1413, 1358),
(1415, 'Oui', 1413, 1359),
(1416, 'Oui', 1413, 1360),
(1418, 'Oui', 1417, 1358),
(1419, 'Oui', 1417, 1359),
(1420, 'Oui', 1417, 1360),
(1422, 'Oui', 1421, 1358),
(1423, 'Non', 1421, 1359),
(1424, 'Non', 1421, 1360),
(1426, 'Non', 1425, 1358),
(1427, 'Oui', 1425, 1359),
(1428, 'Non', 1425, 1360),
(1430, 'Non', 1429, 1358),
(1431, 'Oui', 1429, 1359),
(1432, 'Non', 1429, 1360),
(1434, 'Oui', 1433, 1358),
(1435, 'Oui', 1433, 1359),
(1436, 'Non', 1433, 1360),
(1438, 'Non', 1437, 1358),
(1439, 'Non', 1437, 1359),
(1440, 'Non', 1437, 1360);

-- --------------------------------------------------------

--
-- Structure de la table `reponseqcm`
--

CREATE TABLE IF NOT EXISTS `reponseqcm` (
  `IDREPONSEQCM` int(11) NOT NULL,
  `LIBELLE` varchar(255) DEFAULT NULL,
  `QUESTIONBYIDQUESTION_IDQUESTION` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDREPONSEQCM`),
  KEY `FK_REPONSEQCM_QUESTIONBYIDQUESTION_IDQUESTION` (`QUESTIONBYIDQUESTION_IDQUESTION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '1450');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `formulairereponses`
--
ALTER TABLE `formulairereponses`
  ADD CONSTRAINT `FK_FORMULAIREREPONSES_CUSTOMERBYIDUSER_ID` FOREIGN KEY (`CUSTOMERBYIDUSER_ID`) REFERENCES `customer` (`ID`);

--
-- Contraintes pour la table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK_QUESTION_PARAMTYPEQUESTIONBYIDTYPE_IDTYPE` FOREIGN KEY (`PARAMTYPEQUESTIONBYIDTYPE_IDTYPE`) REFERENCES `paramtypequestion` (`IDTYPE`),
  ADD CONSTRAINT `QSTIONQESTIONNAIREBYIDQUESTIONNAIREIDQUESTIONNAIRE` FOREIGN KEY (`QUESTIONNAIREBYIDQUESTIONNAIRE_IDQUESTIONNAIRE`) REFERENCES `questionnaire` (`IDQUESTIONNAIRE`);

--
-- Contraintes pour la table `questionnaire`
--
ALTER TABLE `questionnaire`
  ADD CONSTRAINT `FK_QUESTIONNAIRE_CUSTOMERBYIDUSER_ID` FOREIGN KEY (`CUSTOMERBYIDUSER_ID`) REFERENCES `customer` (`ID`);

--
-- Contraintes pour la table `reponse`
--
ALTER TABLE `reponse`
  ADD CONSTRAINT `FK_REPONSE_QUESTIONBYIDQUESTION_IDQUESTION` FOREIGN KEY (`QUESTIONBYIDQUESTION_IDQUESTION`) REFERENCES `question` (`IDQUESTION`),
  ADD CONSTRAINT `RPONSEFORMULAIREREPONSESBYIDFORMULAIREIDFORMULAIRE` FOREIGN KEY (`FORMULAIREREPONSESBYIDFORMULAIRE_IDFORMULAIRE`) REFERENCES `formulairereponses` (`IDFORMULAIRE`);

--
-- Contraintes pour la table `reponseqcm`
--
ALTER TABLE `reponseqcm`
  ADD CONSTRAINT `FK_REPONSEQCM_QUESTIONBYIDQUESTION_IDQUESTION` FOREIGN KEY (`QUESTIONBYIDQUESTION_IDQUESTION`) REFERENCES `question` (`IDQUESTION`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
