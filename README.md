# ANSI/VT100 for Java (0.1.8)

Add ansi code to your output
----------------------------

```java
	public static void main(String ... args) throws Exception {
		  String summery = "";
		  Ansi ansi = new Ansi(){};
		  summery += ansi.Yellow("HelloY ");
		  summery += ansi.Blue("WorldB ");
		  summery += ansi.Greenbg("\ttry green background");
		  System.out.println(summery);
	}
```


![screenshot](https://github.com/salemebo/Java-Terminal-ANSI-VT100/blob/master/img/img01.png)

print footer from as of 3-line

```java 
  String summery = "";
  summery += ANSI.EraseLine + "\n" ;
  summery += ANSI.EraseLine + "\n" ;
  summery += ANSI.EraseLine + ANSI.SaveCursor;


  summery += "\r ";
  summery += Ansi.Yellow;
  summery += "Hello ";
  summery += Ansi.ResetAllAttributes;

  summery += Ansi.Blue;
  summery += "World!";
  summery += Ansi.ResetAllAttributes;

  summery += Ansi.Green;
  summery += "\t Tray ANSI code in Java";
  summery += Ansi.ResetAllAttributes;


  summery += Ansi.UnsaveCursor;
  summery += Ansi.CursorUp;
  summery += Ansi.EraseLine;
  summery += Ansi.CursorUp;
  summery += Ansi.EraseLine;
  
  System.out.print(summery);

```
![screenshot](https://github.com/salemebo/Java-Terminal-ANSI-VT100/blob/master/img/img02.png)
