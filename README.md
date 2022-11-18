In Aufgabe 3 wurde ein Algorithmus implementiert, der, gegeben einen gerichteten Graphen, dessen starke Zusammenhangskomponenten findet. Wir haben uns dazu entschieden, dies in Java zu tun. Die generelle Idee unseres Algorithmus lautet wie folgt:

Zuerst wird DFS auf einen willkürlichen Knoten im Graphen aufgerufen und der Knoten, der die größte FinishingTime besitzt, muss eine Source des Graphen sein. Dann weiß man, dass derselbe Knoten im transponierten Graphen eine Sink sein muss. Wird dann eine weitere DFS auf diesen Knoten in der transponierten Matrix gestartet, ist das Ergebnis sicher eine starke Zusammenhangskomponente. Das Ergebnis wird in eine Liste geschrieben und anschließend wird DFS auf den Knoten aufgerufen, der die höchste FinishingTime der verbleibenden Knoten hat, usw.
Hierfür haben wir zuallererst eine Import-Funktion geschrieben, die mittels BufferedReader eine .csv-Datei auswertet und den darin enthaltenen Graphen in eine AdjacencyMatrix parst. In der main-Funktion befinden sich außerdem eine Funktion, die eine gegebene Matrix transponiert, ein loop, der das oben geschriebene Konzept ausführt und eine Funktion, die gefundene starke Zusammenhangskomponenten in eine ArrayList schreibt und diese ausgibt.

DFS wurde auf zwei Arten implementiert. Die erste Version bekommt als Parameter nur eine AdjacencyMatrix, die zweite ist eine überladene Funktion, die noch einen zusätzlichen Parameter bekommt, der festlegt, in welchem Knoten DFS gestartet werden soll.  Wenn DFS aufgerufen wird, wird die Farbe der Knoten auf weiß zurückgesetzt, finCounter (der zum Nachverfolgen der FinishingTime benötigt wird) wird auf 0 gesetzt. Dann wird überprüft, ob der momentane Knoten weiß ist und ob noch keine starke Zusammenhangskomponente gefunden wurde, der der Knoten angehört; ist dies der Fall wird DFS-Visit auf diesen Knoten aufgerufen. In DFS-Visit wird dieser Knoten mit der Farbe grau markiert und anschließend wird in der AdjacencyMatrix nach Kanten zu anderen Knoten gesucht. Wird eine Kante gefunden, wird überprüft, ob der dazugehörige Knoten weiß ist und ob er keiner starken Zusammenhangskomponente angehört; ist dies der Fall wird DFS-Visit auf den benachbarten Knoten aufgerufen usw. Dies geschieht so lange, bis ein Pfad komplett abgelaufen wurde. Dann wird der letzte Knoten des Pfades auf schwarz gesetzt, der finCounter wird in den dazugehörigen Array geschrieben, der die FinishingTimes speichert.

Im Mainloop des Programms wird zuallererst DFS auf den Graphen angewendet, dann die überladene DFS auf den transponierten Graphen und es wird eine Funktion aufgerufen, die die größte FinishingTime des ersten DFS-Durchlaufs findet und der dazugehörige Knoten wird der überladenen DFS als Quellindex übergeben. Auf diese Art und Weise wird der komplette Graph durchgangen und starke Zusammenhangskomponenten werden als ArrayList in eine ArrayList geschrieben anschließend ausgegeben.