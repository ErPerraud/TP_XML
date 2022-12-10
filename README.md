Technologies XML/JSON
****************************

* Sur 2 semaines : 2 * 3 créneaux
* Une évaluation sous la forme d'une note de TP

ATTENTION : ne pas consulter les répertoires `original`.


Introduction
============

XML/JSON Qu'est ce que c'est ?

"Ensemble de règles de grammaire mais pas un langage. Par exemple : XHTML est un langage qui donne un sens au balise et qui respecte la syntaxe XML" C'est-à-dire ?

 A quoi ca sert ? 
* structurer des données
* stocker des données virtuelles dans un système de fichier
* échanger des données entre des entités distantes ou de nature différentes (client serveur)

 
Exercice 1 : XML bien formé
==========

Pré: 
* en partant de ce que connaissant les étudiants, rappeler les règles de grammaire et définir les termes "bien formé" et "valide"

Post:
* expliquer les entités

1. Déterminer *à la mano* les erreurs d'un document XML buggué fourni et remettre la liste des erreurs avec leur ligne

2. Déterminer les erreurs à l'aide d'un outil automatique et modifier le fichier pour le rendre bien formé.

Sur MADOC vous trouverez des liens d'outils en ligne pour vérifier la bonne formation (well formed) d'un fichier XML par exemple [well formed XML checker by liquid-technologies](https://www.liquid-technologies.com/online-xml-validator).

Sauf problème technique, préférez l'usage de la commande `xmllint` 

Par défaut (avec seulement le nom du fichier XML à analyser en paramètre), `xmllint` (package `libxml2-utils`)  vérifie si le document est bien formé. Par défaut aussi la commande reproduit sur la sortie standard le contenu du document donné en entrée. Si il y a des erreurs celles-ci sont affichées en amont du document reproduit.

    xmllint --noout biblio01.xml 

Un extrait du manuel (obtenu par la commande `man xmllint`) :

    xmllint [options] <document xml>
    --dtdvalid URL              Use the DTD specified by an URL for validation
    --valid              Determine if the document is a valid instance of the included Document Type Definition (DTD).     
    --schema SCHEMA             Use a W3C XML Schema file named SCHEMA for validation.
    --relaxng SCHEMA             Use RelaxNG file named SCHEMA for validation.


Exercice 2 : XML valide via une DTD
==========

Pré-requis :
* Présenter ce qu'est une DTD à l'aide de l'exo2 ; Ici des compléments : [DTD](https://gilles-chagnon.developpez.com/cours/xml/dtd-et-schemas/?page=page-1)
* Lire [principes DTD et limites ; principes XSchéma](http://gilles-chagnon.developpez.com/cours/xml/dtd-et-schemas/?page=schemas#LII-A-1)
* Présenter ce qu'est un XSchema à l'aide de l'exo3 notamment les notions de :
- cardinalité (notamment par défaut)
- sequence, choice, all
- la définition de type : 
  - complexType (au moins un attribut), 
  - attribut mixed si attribut et contenu textuel
  - simpleContent pour définir des types qui ont éventuellement un attribut mais ne contiennent pas de sous-élément e.g. <poids unite="kg">67</poids>

1. Vérifier si le fichier XML donné est bien formé

2. Modifier le fichier XML pour le rendre valide via la DTD donnée. Utiliser l'outil spécifié par votre chargé de TD. Vous pouvez consulter le répertoire exemples.

Vous pouvez utiliser le [DTD checker by xmlvalidation](https://xmlvalidation.com/) pour vérifier la validité. Pour cela, 
  1. rajouter ce qui suit après la 1ère ligne dans le document XML (i.e. <?xml... ?>)
  2. dans le code ci-dessous, remplacer le "ICI COPIER COLLER LE CONTENU DU FICHIER DTD" par le contenu effectif de votre DTD
  3. utiliser le validateur en ligne 

    <!DOCTYPE examen [
    ICI COPIER COLLER LE CONTENU DU FICHIER DTD
    ]>

Vous pouvez aussi utiliser la commande `xmllint` :

    xmllint --noout --dtdvalid exam.dtd exam.xml

    Si vous intégrez la DTD dans le fichier XML la commande est xmllint --noout --valid exam.xml

3. Repartir du fichier XML original et cette fois-ci modifier la DTD. Explorer. Chercher par exemple à ajouter un attribut obligatoire avec une valeur par défaut. Est-ce possible ?

4. Comment marque t on la séquence d'éléments ? l'alternative d'éléments ? Que signifie '*', '+', '?' ? Comment spécifier une valeur par défaut pour un attribut ? une valeur obligatoire ? 


Exercice 3 : XML valide via un XSchema
==========

1. Vérifier si le fichier donné est bien formé

2. Modifier le fichier XML pour le rendre valide via le XSchema (XSD) donné. Utiliser l'outil spécifié par votre chargé de TD. Vous pouvez consulter le répertoire exemples.

Vous pouvez utiliser le service en ligne [validator xsd](https://www.freeformatter.com/xml-validator-xsd.html) pour vérifier la validité.

Vous pouvez aussi utiliser la commande `xmllint` :

    xmllint --noout --schema library03.xsd library03.xml 

3. Repartir du fichier XML original et cette fois-ci modifier la XSD. Explorer. Chercher par exemple à ajouter à l'élément `born` un attribut `age` qui ne peut être que de 1 à 3 digits. Même question mais cette fois-ci un élément et non un attribut. Définissez un seul et même type. Tentez de rajouter un élément complexe avec une sructure 'choice' (age ou born par exemple)

4. Pour la semaine suivante, produire un diagramme de classe correspondant au XSD original.


Exercice 4 : Génération de schémas
==========

* Tester les différents outils de générations de schémas XSD et comparer les résultats obtenus avec les schémas fournis. Noter les différences.

xml2dtd
à l'aide de dtdgen issu de saxon http://saxon.sourceforge.net/dtdgen.html
  
    java -cp dtdgen.jar DTDGenerator  exemple.xml >  exemple.dtd

xml2xsd
http://xmlbeans.apache.org/
http://xmlbeans.apache.org/docs/2.0.0/guide/tools.html
  
    ./inst2xsd exemple.xml*

dtd2xsd
http://www.w3.org/2000/04/schema_hack/ 
  
    ./dtd2xsd.pl  

Ces outils ne sont pas récents et certains sont dépréciés.


Exercice 5 : Génération d'une API java à partir d'un XML Schéma
==========

Pré-requis : 
* Java Architecture for XML Binding (JAXB) provides an API and tools that automate the mapping between XML documents and Java objects.
* Les outils jaxb (notamment xjc) sont disponibles ici https://javaee.github.io/jaxb-v2/
* Avant d'aller plus loin il est impératif que vous consultiez l'exemple de code dans le répertoire examples/jaxb.
Un autre exemple de code avec explication se trouve aussi ici https://www.oracle.com/technical-resources/articles/javase/jaxb.html (anciennement http://www.oracle.com/technetwork/articles/javase/jaxb-141136.html)

Soient
  * library03.xsd
  * library03.xml

1.Valider un document XML

    xmllint --schema library03.xsd library03.xml --noout 

2.A l'aide des techno JAXB (outil `xjc`), générer l'API correspondant au XSchéma de l'exercice 3. Comprendre la signification des paramètres des commandes. 

    mkdir src
    xjc -p my.library library03.xsd -d src

3.Manipuler l'API : Développer le code java que vous nommerez `ListeMoiCa.java` (sous la forme d'un main exécutable) qui permet de charger le document XML de l'exercice et qui exploite l'API générée et l'API JAXB pour générer dynamiquement le texte suivant avec le caractère de tabulation comme séparateur pour les lignes décrivant les ouvrages. Si vous développez sous windows veiller à ce que l'encoding soit UTF-8 ou bien n'utiliser pas d'accents.

    La base contient 2 livre(s)
    isbn  disponibilité langue  titre  premier-auteur id nombre-de-personnages
    0836217462  yes en Being a Dog Is a Full-Time Job  Charles M Schulz (CMS) 4 
    0836217461  no fr Le tour du monde en 80 jours Jules Vernes (JV) 2

Pour rappel, compiler en ligne de commande avec

    mkdir bin
    javac -d bin src/my/library/*
    javac -sourcepath src -d bin ListeMoiCa.java 

Pour rappel, exécuter en ligne de commande avec :

    java -classpath bin ListeMoiCa library03.xml

Warnings :
* A partir de java 10 les paquets ont été réorganisés autrement et la notion de module est apparu. Pour pouvoir utiliser java.xml.bind il faut le préciser : 

    javac --add-modules java.xml.bind -d bin src/my/library/*
    javac --add-modules java.xml.bind -sourcepath src -d bin ListeMoiCa.java 
    java  --add-modules java.xml.bind -classpath bin ListeMoiCa library03.xml

* A partir de java 12, le module java.xml.bind a totalement disparu et la solution fonctionnant avec java 10 n'est plus possible. En Septembre 2019, nous contournons le problème en utilisant une version rétrograde de java qui inclut en natif le paquet. Nous faisons cela soit en téléchargeant un jdk soit en utilisant celui installé dans `/usr/lib/jvm/java-8-openjdk-amd64/bin`. Avec cette dernière option, il s'agit de préfixer les commandes `javac` et `java` avec ce path.
Vous pouvez bien entendu ajouter les dépendances issus de jaxb dans votre classpath...


Exercice 06 : quelques mots sur la structure d'un fichier JSON et sur les schémas json
===========

La version library06.xml correspond à la version library03.xml avec un contenu multiplié artificiellement 10 fois.

1.Convertisser le document library06.xml à l'aide du service en ligne http://www.utilities-online.info/xmltojson

2.Quelle est la signification des accolades '{...}' et des parenthèses carrées '[...]' ? Donner un exemple d'élément XML converti ayant résulté en chacune de ces structures.
Observer la conversion des éléments `titre`. Comment ont été convertis l'attribut et le contenu textuel ?
  
  => Une accolade '{...}' signifie que les lignes comprises dans celles-ci resprésentent un élément du document XML.
  => Les crochets '[...]' signifient ques les éléments compris dans ces dernières correspondent à des éléments d'une liste.
  => L'élément 'library' créé une paire d'accolades et l'élément 'book' créé une paire d'accolades
  => Dans l'élément 'titre', le nom de l'attribut et son contenu ont été mis en forme de cette façon : "nom-attribut: 'contenu textuel'"

Quelle taille en ko font respectivement le fichier XML et le JSON correspondant ?

  => Taille XML : 9,0 ko
  => Taille JSON : 10,6 ko

Utilisez les commandes pour supprimer les caractères vides inutiles 

    cat library06.xml | perl -ne 's/^\s+//g; s/\s+$//g;  print' > lib6.xml 
    cat library06.json | perl -ne 's/^\s+//g; s/\s+$//g;  print' > lib6.json 

Même question, quelle taille en ko font respectivement le fichier XML et le JSON correspondant ?

  => Taille XML : 7,4 ko
  => Taille JSON : 6,3 ko

Lequel est le plus verbeux ?

  => Le plus verbeux est donc le fichier XML.

3. Il est possible de spécifier des schémas pour les documents json. Le document https://json-schema.org/learn/getting-started-step-by-step.html vous permet de prendre en main la syntaxe d'un schéma json (vous n'êtes pas obligé de le lire en profondeur). En quelques mots, le schéma "définit" chaque objet (i.e. chaque niveau d'imbrication). La définition d'un objet compte le `type` de l'objet, l'ensemble de ses propriétés `properties` (avec pour chacune son type (e.g. "string", "integer", "objet"), et en général, au moins, une description/titre) ainsi que la spécification des propriétés obligatoires (`required`). Si la propriété est un objet alors récursivement on retrouve la même structure définitoire pour chaque propriété. Pour éviter d'avoir plusieurs niveaux d'imbrication et pour éviter de dupliquer les définitions, il est possible de donner la liste des définitions d'objets et d'utiliser un système de référence pour spécifier les liens d'imbrication entre les objects (i.e. un objet est une propriété d'un autre).

Après avoir identifier le numéro de la dernière version de la spécification des schémas json sur https://json-schema.org/specification.html, utilisez l'outil de conversion en ligne https://app.quicktype.io/#l=schema pour obtenir un schéma json du fichier lib6.json. 

Quelle est la dernière version de la spécification ? Quelle est la version supportée par l'outil de conversion ?

  => La dernière version de la spécification est la version 2020-12. La version supportée par l'outil est : 

Outre le type "object", quels autres types identifiez-vous ? 

Quelles propriétés sont des tableaux d'objets ? 

Par quels mécanismes est-il possible de spécifier les valeurs possibles d'un objet de type string ? Si de tels mécanismes existent les nommer et donner des exemples.

Est-ce qu'un personnage `character` peut-être un auteur `author` (si tel est le cas donnez aussi le code qui illustre cela) ? 

Pour info, différents outils de validation et de conversion sont disponibles sur https://json-schema.org/implementations.html


Exercice 07
===========

Votre travail est à rendre en binôme. Déposer sur madoc votre travail sous la forme d'une archive que vous nommerez `NOM1-NOM2_twc_xml.zip` et qui contiendra vos réponses aux questions : 

* exercice 02 question 3 : votre réponse sur comment "spécifier dans une DTD qu'un attribut est obligatoire avec une valeur par défaut" (un exemple de code avec une explication est suffisant)
  * <!ATTLIST examen code NMTOKEN CDATA "0" #REQUIRED>
* Ici, la valeur située après le 'CDATA' correspond à la valeur par défaut, et '#REQUIRED' signifie que l'attribut 'code' est obligatoire.

* exercice 02 question 4
  * a. Comment marque t on la séquence d'éléments ? 
    * -> La séquence d'éléments est est marquée par "<!ELEMENT nom (elt1, elt2, ...,eltn)>"
  * b. l'alternative d'éléments ?
    * -> <!ELEMENT nom (elt1?, (elt2 | ... | eltn))>
  * c. Que signifie '*', '+', '?' ?
    * -> Ce sont les cardinalités applicables sur les éléments :
      - ? : 0:1
      - + : 1:+infini
      - * : 0:+infini
  * d. Comment spécifier une valeur par défaut pour u2xsd.pl [-alias] [-prefix p] [-ns n] [file]n attribut ? une valeur obligatoire ?
    * -> Pour spécifier une valeur par défaut : CDATA "val_defaut" ;
    * -> Pour spécifier une valeur obligatoire : #REQUIRED

* exercice 03 : un diagramme de classe correspondant au XSD original de l'exercice 03
* 
* exercice 03 question 3 : votre réponse sur comment "définir dans un XSD un attribut et un élément `age` qui ne peuvent être que de 1 à 3 digits et ce pour l'élément `born` (un exemple de code avec une explication est suffisant) 
* 
* 
* exercice 05 : le projet java, en particulier les répertoires/fichiers `src` (fichiers source généré/développé et autres), `bin` (binaire), `xml` et `xsd` ; avec VOS NOMS EN COMMENTAIRE DANS L'EN-TÊTE du fichier développé !
* 
* 
* exercice 06 question 2
* 
* 
* exercice 06 question 3
* 
* 

Une attention particulière sera donnée à votre sensibilité à vous mettre à la place de l'utilisateur/correcteur de votre rendu : veiller à mettre les fichiers nécessaires pour que votre projet soit auto-suffisant, indiquer l'usage de votre code aussi bien pour la compilation et l'exécution en ligne de commande, indiquer l'avancement (i.e. les questions qui ont été traitées, qui fonctionnent et leur pendant), ...

Divers
============
* S'il est disponible le programme `tidy` peut signaler les erreurs de documents XML mal formés, voire les corriger... A ne pas utiliser pour notre exercice.
* https://json-schema.org/
