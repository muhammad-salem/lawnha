# ANSI/VT100 for Java (0.1.96)


Control Sequences (defined by ANSI X3.64-1979)
----------------------------------------------

Control Sequences are started by either ESC [ or CSI and are terminated by an
"alphabetic" character (100 to 176 octal, 40 to 7E hex).  Intermediate
characters are space through slash (40 to 57 octal, 20 to 2F hex) and parameter
characters are zero through question mark (60 to 77 octal, 30 to 3F hex,
including digits and semicolon).  Parameters consist of zero or more decimal
numbers separated by semicolons.  Leading zeros are optional, leading blanks
are not allowed.  If no digits precede the final character, the default
parameter is used.  Many functions treat a parameter of 0 as if it were 1.


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

![screenshot](https://github.com/salemebo/Java-Terminal-ANSI-VT100/blob/master/img/img03.png)
![screenshot](https://github.com/salemebo/Java-Terminal-ANSI-VT100/blob/master/img/img04.png)
![screenshot](https://github.com/salemebo/Java-Terminal-ANSI-VT100/blob/master/img/img05.png)


