Soient
  * monXSchema.xs
  * unXMLDocument.xml

Valider un document XML

	xmllint --schema exemple.xsd exemple.xml --noout 

Générer l'API correspondant à un XML Schema pour être intégrer dans un certain package

  mkdir src
	xjc -p mon.paquet exemple.xsd -d src

Manipuler l'API
	* Un exemple de code avec explication http://www.oracle.com/technetwork/articles/javase/jaxb-141136.html

	* Un autre exemple : Voir le support de Anders Moeller de la diapo 26 à 33 (en particulier la 33 !)

JaxbExemple
	# compilation
		javac  -d bin src/mon/paquet/*
		javac -sourcepath src  -d bin JaxbExemple.java 

	# exécution
	java -classpath bin JaxbExemple exemple.xml
