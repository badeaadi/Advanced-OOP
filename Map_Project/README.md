Map Project -
It is given a map marked by certain nodes(towns to visit or activities to do), with some transporation possibilities.

Classes involved:

1.**Node** : Abstract class with: 
⋅⋅*"getIndex" method which gets the index from some town or activity name⋅⋅
     
2.**Town** : 
    - Class to be populated from Main with objects

3.**Activity** : 
    - Addition from town and node - has some happiness index which will be used afterwards

4.**Transport**:
    - Contains name of transport, and several details of the transportation method
    - Has "displayTransport" method which gives a full detail in System.out about itself.
    - Has pedestrian and bicycle transportation types already given(lets the user decide wheter to use them in Main)

5.**Road**:
    -Ties towns or activities one to another
    -Has method "isPossible" which decides if a certain transportation method is fit for this road
    -Has method "getCost" which calculates the Cost based on a Road and a certain transportation unit
    Has method "displayRoad" which hives a full detail about the road.
    
6.**Cost**:
    - Instantiable class with more constructors
    - Has Method "addCost" which calculates the sum of two costs
    - "toString" method overloaded, which gives our description about this object.
    
7.**CostTime**, **CostDistance**, **CostDistance**
    - All implement Comparator<Cost>, will be used in Dijsktra's Algorithm.
    
8.**Harta** 
    - Service class, used for implementing operations for the given network.
    - Is Singleton, is instantiated within Main class and has only one instance
    - Has static arrayLists which contain roads, towns and transportations methods,
    - Has "addRoad", "addTown", "addTransportation" methods, which gives puts in the network another object to use.
    - Has "getCost" method, which implements Disjktra's algorithm for the given indexes, or string(i.e gets the best road from some certain town to another)
    - Has "getBestTime", "getBestDistance", "getBestPay" methods, which use the comparators from Cost.
    - So, the graph minimum distance algorithm is implemented for time, distance, and price within the same code(just changing the given PriorityQueue)
    - Has "displayAllBest" which gives the best three ways from a node to another
    
9.**Main**
    - Is split in two functions, one uploads the information to the graph, and the other queries the graph
    
