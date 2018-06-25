# ANSI/VT100 for Java (0.1.6)

Add ansi code to your output
----------------------------

```java
	public static void main(String ... args) throws Exception {
		  String summery = "";
		  ANSI ansi = new ANSI(){};
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
  summery += ANSI.Yellow;
  summery += "Hello ";
  summery += ANSI.ResetAllAttributes;

  summery += ANSI.Blue;
  summery += "World!";
  summery += ANSI.ResetAllAttributes;

  summery += ANSI.Green;
  summery += "\t Tray ANSI code in Java";
  summery += ANSI.ResetAllAttributes;


  summery += ANSI.UnsaveCursor;
  summery += ANSI.CursorUp;
  summery += ANSI.EraseLine;
  summery += ANSI.CursorUp;
  summery += ANSI.EraseLine;
  
  System.out.print(summery);

```
![screenshot](https://github.com/salemebo/Java-Terminal-ANSI-VT100/blob/master/img/img02.png)
