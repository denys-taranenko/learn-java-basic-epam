# Java Programming Tasks

This document contains descriptions of various problems for practicing Java programming. Each problem is accompanied by a link to the corresponding class in which it can be solved and detailed instructions.

---

## First Programs in Java

### [MeetAuto Code](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_1_first_programs_in_java/task_1_meet_autocode)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>HelloAutocode</code> class and write a simple program that prints <i>"Hello, Autocode!"</i> (don't print quote marks).
  </p>
</details>

### [Meet a Stranger](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_1_first_programs_in_java/task_2_meet_a_stranger)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to the class <code>MeetAStranger</code>. The program must read a string from <code>System.in</code> and print a message <i>"Hello, input"</i>. Note that when entering an input string consisting of several words, the entire input must be printed.
  </p>
</details>

---

## Data Types

### [Electronic Watch](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_2_data_types/task_1_electronic_watch)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>ElectronicWatch</code> class. The program must print an electronic watch screen output for a given value of seconds since midnight.<br>
    Input value is given via <code>System.in</code>. Output value must be printed to <code>System.out</code>. It is guaranteed, that input number is non-negative.<br>
    Output format is <code>h:mm:ss</code> (possible values: [0:00:00; 23:59:59]).<br>
    <i>Extra challenge:</i> Try to solve the task without using <code>if</code> statements or cycles.
  </p>
</details>

---

## Conditions and Loops

### [Meet an Agent](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_1_meet_an_agent)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>MeetAnAgent</code> class and write a program that:<br>
    <ul>
      <li>Asks for an input number;</li>
      <li>If the input equals to the secret password number, prints <I>"Hello, Agent"</i>;</li>
      <li>Otherwise, prints <I>"Access denied"</i>.</li>
    </ul>
    Secret password is stored in <code>final static int PASSWORD</code>.<br>
    It is guaranteed that the input is not null.
</details>

### [Meet Strangers](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_2_meet_strangers)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>HelloStrangers</code> class and write a program that:<br>
    <ul>
      <li>Asks for a number - amount of strangers to meet;</li>
      <li>Then reads stranger names line by line;</li>
      <li>And, finally, prints line by line <I>"Hello, stranger name"</i> for each stranger.</li>
    </ul>
    It is guaranteed that the input is not null. It is guaranteed that the input of strangers count is int number.<br>
    Consider special cases:<br>
    <ul>
      <li>If strangers count is zero, then program must print <I>"Oh, it looks like there is no one here"</i>.</li>
      <li>If strangers count is negative, then program must print <I>"Seriously? Why so negative?"</i>.</li>
    </ul>
</details>

### [Snail](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_3_snail)
<details>
  <summary>Task</summary>
  <p>
    Consider a snail travels up a tree <code>a</code> feet each day. Then snail slides down <code>b</code> feet each night. Height of the tree is <code>h</code>.<br>
    Please, proceed to <code>Snail</code> class and write a program that prints number of days for the snail to reach the top of the tree.<br>
    Program reads <code>a</code>, <code>b</code>, <code>h</code> line by line. Input values are guaranteed to be positive integers.<br>
    If the snail cannot reach the top of the tree, print the message <i>"Impossible"</i>.
  </p>
</details>

### [Go Dutch](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_4_go_dutch)
<details>
  <summary>Task</summary>
  <p>
    Consider a company of friends visiting a restaurant. They decided to equally split the bill.<br>
    Friends decided to add 10 percent of the bill total amount as tips. Then they cover the total payment in equal parts.<br>
    Please, proceed to <code>GoDutch</code> class and write a program that reads a bill total amount and a number of friends, and then prints part to pay.<br>
    Consider some details:<br>
    <ul>
      <li>Program must read data from <code>System.in</code>;</li>
      <li>Bill total amount cannot be negative. If input value is negative, the program stops, printing: <i>"Bill total amount cannot be negative"</i>;</li>
      <li>Number of friends cannot be negative or zero. If input value is, then the program stops, printing: <I>"Number of friends cannot be negative or zero"</i>;</li>
      <li>Bill total amount, number of friends and part to pay are integers.</li>
    </ul>
</details>

### [Max Value In Sequence](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_5_max_value_in_sequence)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>FindMaxInSeq</code> and write a program that reads a sequence of integer values from standard output and finds the maximum value. You must place your solution into the <code>max</code> method to pass tests.<br>
    Details:
    <ul>
      <li>You must read sequence values until the next one is <code>0</code>. Zero value means end of the input sequence.</li>
      <li>The sequence is guaranteed to contain at least one value.</li>
    </ul>
</details>

### [Average](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_6_average)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>Average</code> class and write a program that reads a sequence of integer values from standard output and finds the average value.<br>
    Details:<br>
    <ul>
      <li>You must read sequence values until the next one is <code>0</code>. Zero value means end of the input sequence.</li>
      <li>The sequence is guaranteed to contain at least one value.</li>
      <li>Average value is also an <strong>integer</strong>. Use <strong>integer</strong> operations.</li>
    </ul>
</details>

### [Pizza Split](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_7_pizza_split)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>PizzaSplit</code> class. The program must read two values from <code>System.in</code>:<br>
    <ul>
      <li>Number of people;</li>
      <li>Number of pieces per pizza.</li>
    </ul>
    It is guaranteed that these values are positive integers.<br>
    Then the program must print the minimum number of pizzas (not zero) so that everyone has an equal number of slices and no slice is left.<br>
</details>

### [Quadratic Equation](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_3_conditions_and_loops/task_8_quadratic_equation)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to the <code>QuadraticEquation</code> class and implement a program to solve quadratic equations.<br>
    For the given quadratic equation coefficients <strong>(ax<sup>2</sup> + bx + c = 0)</strong>, return one or two roots of the equation if there is any in the set of real numbers.<br>
    Input value is given via <code>System.in</code>. Output value must be printed to <code>System.out</code>.<br>
    Output format is:
    <ul>
      <li><code>x1 x2</code> (two roots in any order separated by space) if there are two roots,</li>
      <li><code>x1</code> (just the value of the root) if there is the only root,</li>
      <li><code>no roots</code> (just a string value <i>"no roots"</i>) if there is no root.</li>
    </ul>
</details>

---

## Arrays

### [Max method](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_1_max_method)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to the <code>MaxMethod</code> class and implement the <code>max</code> method.<br>
    The correct implementation should receive an array of <code>int</code> values and return its maximum value.<br>
    Details:<br>
    <ul>
      <li>An input array is guaranteed to not be an empty array or <code>null</code>.</li>
      <li><code>max</code> method must not modify the array.</li>
      <li>Input array may contain any <code>int</code> value between <code>Integer.MIN_VALUE</code> and <code>Integer.MAX_VALUE</code>.</li>
    </ul>
</details>

### [Sum of even numbers](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_2_sum_of_even_numbers)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to the <code>SumOfEvenNumbers</code> class and implement the <code>sum</code> method.<br>
    The correct implementation should receive an array of <code>int</code> values and return the sum of even numbers.<br>
    Details:<br>
    <ul>
      <li>If given array is null or empty, method returns 0.</li>
      <li><code>sum</code> method must not modify the array.</li>
      <li>Input array may contain any <code>int</code> value between <code>Integer.MIN_VALUE</code> and <code>Integer.MAX_VALUE</code>.</li>
    </ul>
</details>

### [Sum of previous](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_3_sum_of_previous)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>SumOfPrevious</code> class and implement <code>getSumCheckArray</code> method.<br>
    The correct implementation should receive an array of <code>int</code> values and return an array of booleans where each element is a result of a check if a corresponding element is a sum of two previous elements in given array.<br>
    Details:<br>
    <ul>
      <li>The length of given array is guaranteed to be 2 or more.</li>
      <li>Given array is guaranteed to be not null.</li>
      <li>Method returns an array of booleans where each element is a result for corresponding element in given array.</li>
      <li>First two elements of the boolean array are always false.</li>
    </ul>
</details>

### [Local maxima remove](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_4_local_maxima_remove)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to the LocalMaximaRemove class and implement the <code>removeLocalMaxima</code> method.<br>
    The correct implementation should receive an array of <code>int</code> values and return a copy of a given array with all local maxima removed in it. The original array must not be changed.<br>
    <strong>Local maximum</strong> is an element that is bigger that any of its neighbour elements. You should remove elements that are local maxima in the original array.
    Details:<br>
    <ul>
      <li>The size of given array is guaranteed to be more than 1.</li>
      <li>Given array is guaranteed to be not null.</li>
      <li>If the array has no local maxima, then you should return its copy without changes.</li>
      <li>You may use <code>java.util.Arrays.*</code> methods.</li>
    </ul>
</details>

### [Cycle Swap](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_5_cycle_swap)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>CycleSwap</code> class and implement its static methods:<br>
    <ul>
      <li><code>void cycleSwap(int[] array)</code><br>
           Shifts all the elements in the given array in the right direction by 1 position.<br>
           In this case, the last array element becomes first.<br>
           For example, <code>1 3 2 7 4</code> becomes <code>4 1 3 2 7</code>.<br>
      </li>
      <li><code>void cycleSwap(int[] array, int shift)</code><br>
          Shift all the elements in the given array in the right direction in the cycle manner by <code>shift</code> positions.<br>
          Shift value is guaranteed to be non-negative and not bigger than the array length.<br>
          For example, <code>1 3 2 7 4</code> with a shift of 3 becomes <code>2 7 4 1 3</code>.<br>
      </li>
    </ul>
</details>

### [Spiral](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_6_spiral)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>Spiral</code> class and implement its static method:<br>
    <ul>
      <li><code>int[][] spiral(int rows, int columns)</code><br>
           Return a two-dimensional array coming in the form of a table and containing numbers from 1 up to <code>rows * cols</code>. The size of the table will be specified by the given parameters.<br>
           Numbers fill the "table" clockwise from the top-level corner in a spiral manner.<br>
           For example, for parameter values <code>(3, 4)</code> , the output array should be:<br>
           <code>1  2  3  4</code><br>
           <code>10 11 12 5</code><br>
           <code>9  8  7  6</code><br>
      </li>
    </ul>
</details>

### [Matrix Transposition](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_7_matrix_transposition)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>TransposeMatrix</code> class an implement its method <code>multiply</code>.<br>
    It takes a rectangular integer array (matrix) as a parameter and returns it transposed.<br>
    Consider an integer matrix represented as a <strong>rectangular array</strong>. The task is to <strong>transpose</strong> a given matrix over its main diagonal. The <strong>transposition</strong> of a matrix over its main diagonal is simply a flipped version of the original matrix.
</details>

### [Matrices Multiplication](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_4_arrays/task_8_matrices_multiplication)
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>MultiplyMatrix</code> class and implement its <code>multiply</code> method.<br>
    It takes two rectangular integer arrays (matrices) and returns the result of their multiplication.<br>
    Consider two integer matrices represented as <strong>rectangular arrays</strong>. The task is to <strong>multiply</strong> given matrices. The definition of <strong>matrix multiplication</strong> indicates a row-by-column multiplication, where the entries in the <strong>i-th</strong> row of <i>A</i> are multiplied by the corresponding entries in the <strong>j-th</strong> column of <i>B</i> and then the <strong>ij-th</strong> element of the resulting matrix is the sum of that multiplication results.<br>
    Note that it is guaranteed that the number of columns in the first matrix is equal to the number of rows in the second matrix.<br>
</details>

---

## Classes

### [Line Intersection](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_5_classes/task_1_line_intersection)
<details>
  <summary>Task</summary>
  <p>
    Please, implement the method <code>intersection(Line)</code> in class <code>Line</code>. It must return a <code>Point</code> of intersection of two lines.<br>
    Note that lines are defined by linear equations: <code>y = k * x + b</code>. Line constructor takes <code>k</code> and <code>b</code> coefficients as parameters.<br>
    If lines coincide or do not intersect, the method must return null. It may seem surprising that we use <code>int</code> for arguments and fields of coordinates. The point is that using <code>double</code> will bring some extra complexity we want to avoid for this basic exercise. All tests are selected in to induce calculations without remainders.<br>
    You may check your result in class <code>Main</code>.
</details>

### [Segments](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_5_classes/task_2_segments)
<details>
  <summary>Task</summary>
  <p>
    Please, implement the following methods of class <code>Segment</code>:<br>
    <ul>
      <li>Constructor with start and end points as parameters<br>
          Ensure that a created segment exists and is not degenerative which means that the start and the end of the segment is not the same point.<br>
          If it is, use <code>throw new IllegalArgumentException()</code> to raise an error.</li>
      <li><code>double length()</code><br>
          Return length of the segment.</li>
      <li><code>Point middle()</code><br>
          Return a middle point of the segment.</li>
      <li><code>Point intersection(Segment another)</code><br>
          Return a point of the intersection of the current segment and the given one.<br>
          Return <code>null</code> if there is no such point.<br>
          Return <code>null</code> if segments are collinear.<br>
          Please, note that intersection point must lay on both segments.</li>
    </ul>
    Class <code>Point</code> is already there.
    Hints:
    <ul>
      <li><a href="https://www.wikihow.com/Use-Distance-Formula-to-Find-the-Length-of-a-Line">Length reference</a></li>
      <li><a href="https://www.wikihow.com/Find-the-Midpoint-of-a-Line-Segment#Use-the-Midpoint-Formula">Midpoint reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Line%E2%80%93line_intersection">Intersection reference</a></li>
    </ul>
</details>

### [Triangle](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_5_classes/task_3_triangle)
<details>
  <summary>Task</summary>
  <p>
    Please, implement methods of class <code>Triangle</code>:<br>
    <ul>
      <li>Constructor, which has three points as parameters.<br>
          Make sure that these points refer to vertices of the triangle.<br>
          Ensure that the created triangle exists and it is not degenerative.<br>
          If it is, use <code>throw new IllegalArgumentException()</code> to raise an error.</li>
      <li><code>double area()</code><br>
          Return the area of the triangle.</li>
      <li><code>Point centroid()</code><br>
          Return the centroid of the triangle.</li>
    </ul>
    Class <code>Point</code> is already there.
    Hints:
    <ul>
      <li><a href="https://en.wikipedia.org/wiki/Triangle#Existence_of_a_triangle">Triangle existence reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Triangle#Existence_of_a_triangle">Triangle area reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Centroid">Centroid reference</a></li>
    </ul>
    Please note that you may benefit from introducing more classes.
</details>

### [Decrementing Carousel](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_5_classes/task_4_decrementing_carousel)
<details>
  <summary>Task</summary>
  <p>
    <code>Decrementing Carousel</code> is a container, accepting <code>int</code> elements. <code>DecrementingCarousel</code> has a maximum capacity, specified via the constructor. When created, <code>DecrementingCarousel</code> is in accumulating state: you may add elements via the <code>addElement</code> method and can produce a <code>CarouselRun</code> object via the <code>run</code> method. Once the <code>run</code> method is called, <code>DecrementingCarousel</code> is in running state: it refuses adding more elements.<br>
          The <code>CarouselRun</code> allows to iterate over elements of the carousel decrementing them one by one with the <code>next</code> method. The <code>next</code> returns the value of the current element. Then it decreases the current element by one and switches to the next element.<br>
          The <code>CarouselRun</code> iterates over elements in the order of their insertion.<br>
          When an element is decreased to zero, the <code>CarouselRun</code> will skip it in further iterations. When there are no more elements available for decrementing, the <code>CarouselRun</code> returns <code>-1</code>.
          The <code>CarouselRun</code> also has the <code>isFinished</code> method, which indicates, if the carousel has run out of the elements to decrement.<br>
          <strong>Specification Details</strong><br>
          <code>DecrementingCarousel</code> has two public methods:
    <ul>
      <li><code>boolean addElement(int element)</code> - adds an element. If element is negative or zero, do not add the element. If container is full, do not add the element. If the <code>run</code> method was called to create a <code>CarouselRun</code>, do not add the element. If element is added successfully, return <code>true</code>. Return <code>false</code> otherwise.</li>
      <li><code>CarouselRun run()</code> - returns a <code>CarouselRun</code> to iterate over the elements. If the <code>run</code> method has already been called earlier, it must return <code>null</code>: <code>DecrementingCarousel</code> may generate only one <code>CarouselRun</code> object.</li>
    </ul>
          <code>CarouselRun</code> has two public methods:
    <ul>
      <li><code>int next()</code> - returns the current value of the current element, then decreases the current element by one and switches to the next element in insertion order. Skips zero elements. When there is no more elements to decrease, returns <code>-1</code>.</li>
      <li><code>boolean isFinished()</code> - when there is no more elements to decrease, returns <code>true</code>. Otherwise, returns <code>false</code>.</li>
    </ul>
</details>

---

## Introduction to OOP

### [Halving Carousel](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_6_introduction_to_oop/task_1_halving_carousel)
<details>
  <summary>Task</summary>
  <p>
    Note, that if you have not done the "Decrementing Carousel" exercise, you have to implement <code>DecrementingCarousel</code> and <code>CarouselRun</code> classes.<br>
    In this exercise you need to extend <code>DecrementingCarousel</code>. You need to implement <code>HalvingCarousel</code>. This subclass must halve elements instead of decrementing it by one. Note that you need to apply regular integer division, discarding the remainder. For example, <code>5 / 2 = 2</code>.
</details>

### [Gradually Decreasing Carousel](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_6_introduction_to_oop/task_2_gradually_decreasing_carousel)
<details>
  <summary>Task</summary>
  <p>
    Note, that if you have not done the "Decrementing Carousel" exercise, you have to implement <code>DecrementingCarousel</code> and <code>CarouselRun</code> classes.<br>
    In this exercise you need to extend <code>DecrementingCarousel</code>. You need to implement <code>GraduallyDecreasingCarousel</code>. This subclass must decrement elements by gradually increasing decrement. When you need to decrement an element for the first time, decrease it by <code>1</code>. Next time you need to decrement the same element, decrease it by <code>2</code>. Next time decrease by <code>3</code>, then by <code>4</code> and so on. Remember that you must not make process non-positive elements.
</details>

### [Decrementing Carousel with Limit](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_6_introduction_to_oop/task_3_decrementing_carousel_with_limit)
<details>
  <summary>Task</summary>
  <p>
    Note, that if you have not done the "Decrementing Carousel" exercise, you have to implement <code>DecrementingCarousel</code> and <code>CarouselRun</code> classes.<br>
    In this exercise you need to extend <code>DecrementingCarousel</code>. You need to implement <code>DecrementingCarouselWithLimitedRun</code>. This subclass must decrement elements as a usual DecrementingCarousel. The difference is that this implementation must produce a carousel run, which limits number of calls to the <code>next</code> method. When the limit of calls reached carousel run must consider itself finished.
</details>

### [Sprint Planning](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_6_introduction_to_oop/task_4_sprint_planning)
<details>
  <summary>Task</summary>
  <p>
    In this exercise we are going to manage business logic of planning a sprint. A sprint is the basic unit of software development in SCRUM. Sprints are time boxed. Time capacity of a sprint is agreed while planning. Then we consider a sprint to be filled with some tasks.<br>
    We consider a task to be implemented with general-purpose <code>Ticket</code> class. But we also consider a sprint to accept only subtypes of the <code>Ticket</code> class: <code>Bug</code> and <code>UserStory</code>.<br>
    Here is a diagram depicting the public interface of these classes and their relations:<br>

![Diagram](https://raw.githubusercontent.com/denys-taranenko/learn-java-basic-epam/main/sprintDiagram.png)
    Here are API details:<br>
    <ul>
    <li><strong>Ticket</strong><br></li>
    Every ticket has an id, a name and an estimate of hours to complete it. One provides them via the constructor of the <code>Ticket</code> class. Also, a ticket may be completed or not. When a ticket is created, it is not completed.
        <ul>
            <li><code>getId()</code> - Returns the id of the ticket.</li>
            <li><code>getName()</code> - Returns the name of the ticket.</li>
            <li><code>getEstimate()</code> - Returns the estimate of the ticket.</li>
            <li><code>isCompleted()</code> - Returns <code>true</code> if the ticket is completed, <code>false</code> otherwise.</li>
            <li><code>getId()</code> - Returns the id of the ticket.</li>
            <li><code>complete()</code> - Sets the ticket to completed state.</li>
        </ul>
    </ul>
    <ul>
    <li><strong>UserStory</strong><br></li>
    We consider a user story to be a ticket that may contain some dependencies. A dependency is another user story that must be completed first to allow the dependent user story to complete. One provides dependencies of the UserStory via the constructor of the <code>UserStory</code> class.
        <ul>
            <li><code>complete()</code> - Like the <code>Ticket#complete()</code> method, this sets the ticket to completed state. The difference is that the user story may not be completed if its dependencies are not completed yet.</li>
            <li><code>getDependencies()</code> - Returns a defensive copy of dependencies arrays.</li>
            <li><code>toString()</code> - Returns a String representing this user story, using its id and name. Example: "[US 1] User Registration Entity"</li>
        </ul>
    </ul>
    <ul>
    <li><strong>Bug</strong><br></li>
    We consider a bug to be a ticket, that is related to some completed user story. Bugs may not exist by their on, without a related user story.
        <ul>
            <li><code>createBug(int id, String name, int estimate, UserStory userStory)</code> - A static method to create a Bug instance.<br>
                Returns null if the related user story is null or is not completed. Otherwise, returns a created Bug instance.</li>
            <li><code>toString()</code> - Returns a String representing this bug, using its id, name and the name of the related user story.<br>
                Example: with id = 2, name = "Add password repeat" and the related user story name = "Registration Form" the resulting string would be "[Bug 2] Registration Form: Add password repeat"</li>
        </ul>
    </ul>
    <ul>
    <li><strong>Sprint</strong><br></li>
    Sprints has the time capacity and the tickets limit, specified via constructor. It is not allowed for a Sprint to contain tickets with total estimate greater than time capacity. It is not allowed for a Sprint to contain total amount of tickets greater than tickets limit.<br>
    We consider a sprint to accept tickets via <code>add*</code> methods. That methods return <code>true</code> when an input ticket was accepted and <code>false</code> otherwise. Note that we consider a sprint to not accept:<br>
    1. <code>null</code> values.<br>
    2. tickets, that are already completed.<br>
    3. tickets, that has an estimate value that will lead to capacity overflow if added.<br>
    4. any ticket, if the sprint ticket limit is reached.<br>
        <ul>
            <li><code>addUserStory(UserStory userStory)</code> - accepts a userStory, if it is not <code>null</code>, not completed and its uncompleted dependencies are already accepted to the sprint.<br>
            Returns <code>true</code> if the user story is accepted, <code>false</code> otherwise.</li>
            <li><code>addBug(Bug bugReport)</code> - accepts a bug, if it is not <code>null</code> and not completed. Returns <code>true</code> if the bug is accepted, <code>false</code> otherwise.</li>
            <li><code>getTickets()</code> - Returns a defensive copy of the array of the sprint tickets. Make sure the order of tickets is as they were accepted to the sprint.</li>
            <li><code>getTotalEstimate()</code> - Returns the sum of estimates of all the tickets accepted to the sprint.</li>
        </ul>
    </ul>
    <strong>Important restriction:</strong> Note that in this exercise you <strong>may not</strong> use <em>Collections</em> and <em>Streams</em>.
</details>

---

## Abstract Classes and Interfaces

### [Task Carousel](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_7_abstract_classes_and_interfaces/task_1_task_carousel)
<details>
  <summary>Task</summary>
  <p>
    In this exercise you need to design two implementations of the <code>Task</code> interface:<br>
    <ul>
    <li><code>CountDownTask</code>:<br></li>
        <ul>
            <li>The constructor of <code>CountDownTask</code> takes a single int value as a parameter. It is the initial value of the countdown. Input value must not be negative. If it is, set zero value.</li>
            <li>Each time the <code>execute</code> method is called, this value decrements by one, until it reaches zero. Then the <code>execute</code> method no longer decrements the value and the task is considered finished.</li>
            <li>If the task is initialized with zero value, consider it finished right upon creating.</li>
            <li>Value of the task is accessible via getter.</li>
        </ul>
    <li><code>CompleteByRequestTask</code>:<br></li>
        <ul>
            <li>Constructor of the <code>CompleteByRequestTask</code> takes no parameters.</li>
            <li>Calling <code>execute</code> method on the task does not make it finished until the <code>complete</code> method is called.</li>
            <li>Once the <code>complete</code> method is called, the next call to <code>execute</code> makes the task finished. Note that the task is not finished right after calling the <code>complete</code> method. The task finishes only when subsequent call to <code>execute</code> occurs.</li>
        </ul>
    </ul>
    Also, you need to implement the <code>TaskCarousel</code>:<br>
    <ul>
    <li>A task carousel has a capacity provided as a constructor parameter.<br></li>
    <li>The <code>TaskCarousel</code> has <code>isEmpty</code> method. It returns <code>true</code> if there is no task in the carousel for execution. Returns <code>false</code> otherwise.<br></li>
    <li>The <code>TaskCarousel</code> has <code>isFull</code> method. It returns <code>true</code> if there is no more room in the carousel to add another task. Returns <code>false</code> otherwise.<br></li>
    <li>You may add tasks to the carousel via <code>addTask</code> method. It returns <code>true</code> if the task is accepted and <code>false</code> otherwise. Task may be not accepted due to following reasons:<br></li>
        <ul>
            <li>Task argument is null.</li>
            <li>Task is already finished.</li>
            <li>Carousel is full.</li>
        </ul>
    <li>You may execute tasks in the carousel via <code>execute</code> method.<br></li>
        <ul>
            <li>Each time when this method is invoked, carousel must switch to the next task within and execute it.</li>
            <li>Iteration is in circular manner. If there are 4 tasks inside a carousel, then if we call <code>execute</code> method on the carousel 4 times in a row, each task must be executed once.</li>
            <li>If the task is finished after execution, remove it from the carousel.</li>
            <li>The method returns <code>true</code> if any task was executed. Returns <code>false</code> otherwise.</li>
        </ul>
    </ul>
</details>

### [Figures](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_7_abstract_classes_and_interfaces/task_2_figures)
<details>
  <summary>Task</summary>
  <p>
    Please, make <code>Triangle</code>, <code>Quadrilateral</code>, <code>Circle</code> classes extend <code>Figure</code> abstract class.<br>
    Implement methods in <code>Triangle</code>, <code>Quadrilateral</code>, <code>Circle</code>:<br>
<ul>
    <li>1. Constructors with following parameters:<br></li>
        <ul>
            <li><code>Triangle</code> - three vertices (points) as parameters.</li>
            <li><code>Quadrilateral</code> - four vertices (points) as parameters.</li>
            <li><code>Circle</code> - point of the center and double value of the radius.</li>
        </ul>
    All the input datasets in tests are guaranteed to form a non-degenerative figures. For Quadrilaterals, it is guaranteed that all test datasets would form a convex quadrilaterals.
    <li>2. <code>public double area()</code><br></li>
    Return the area of the figure.<br>
    <em>Note:</em> Convex quadrilaterals can be divided into two triangles by any of their diagonals.<br>
    <li>3. <code>public String pointsToString()</code><br></li>
    Return a String value in following formats:<br>
        <ul>
            <li><code>Triangle</code> - </li>
            <ul>
                <li>Format: <code>(a.x,a.y)(b.x,b.y)(c.x,c.y)</code></li>
                <li>Example: <code>(0.0,0.0)(0.1,5.8)(7.0,7.0)</code></li>
            </ul>
            <li><code>Quadrilateral</code> - </li>
            <ul>
                <li>Format: <code>(a.x,a.y)(b.x,b.y)(c.x,c.y)(d.x, d.y)</code></li>
                <li>Example: <code>(0.0,0.0)(0.0,7.1)(7.0,7.0)(7.0,0.0)</code></li>
            </ul>
            <li><code>Circle</code> - </li>
            <ul>
                <li>Format: <code>(center.x,center.y)</code></li>
                <li>Example: <code>(0.0,0.6)</code></li>
            </ul>
        </ul>
    <em>Note:</em> you may benefit from implementing toString() in the <code>Point</code> class.<br>
    <li>4. <code>public String toString()</code><br></li>
    Return a String value in following formats:<br>
        <ul>
            <li><code>Triangle</code> - </li>
            <ul>
                <li>Format: <code>Triangle[(a.x,a.y)(b.x,b.y)(c.x,c.y)]</code></li>
                <li>Example: <code>Triangle[(0.0,0.0)(0.1,5.8)(7.0,7.0)]</code></li>
            </ul>
            <li><code>Quadrilateral</code> - </li>
            <ul>
                <li>Format: <code>Quadrilateral[(a.x,a.y)(b.x,b.y)(c.x,c.y)(d.x, d.y)]</code></li>
                <li>Example: <code>Quadrilateral[(0.0,0.0)(0.0,7.1)(7.0,7.0)(7.0,0.0)]</code></li>
            </ul>
            <li><code>Circle</code> - </li>
            <ul>
                <li>Format: <code>Circle[(center.x,center.y)radius]</code></li>
                <li>Example: <code>Circle[(0.0,0.6)4.5]</code></li>
            </ul>
        </ul>
    <em>Note:</em> you may use default implementation given in the <code>Figure</code> class, when it suits a case well.<br>
    <li>5. <code>public Point leftmostPoint()</code><br></li>
    Return a leftmost point of the figure: the one having the least <code>X</code> coordinate.<br>
    If there are many leftmost points, return any of them.<br>
    </ul>
    <code>Point</code> class is already there.<br>
    Hints:<br>
    <ul>
      <li><a href="https://en.wikipedia.org/wiki/Degeneracy_(mathematics)">Degeneracy reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Quadrilateral#Convex_quadrilaterals">Convex quadrilateral reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Triangle#Computing_the_area_of_a_triangle">Triangle area reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Circle#Area_enclosed">Circle area reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Quadrilateral#Area_of_a_convex_quadrilateral">Quadrilateral area reference</a></li>
    </ul>
</details>

### [Figures. Extra Challenge](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_7_abstract_classes_and_interfaces/task_3_figures_extra_challenge)
<details>
  <summary>Task</summary>
  <p>
    Please, make <code>Triangle</code>, <code>Quadrilateral</code>, <code>Circle</code> classes extend <code>Figure</code> abstract class.<br>
    Implement methods in <code>Triangle</code>, <code>Quadrilateral</code>, <code>Circle</code>:<br>
<ul>
    <li>1. Constructors with following parameters:<br></li>
        <ul>
            <li><code>Triangle</code> - three vertices (points) as parameters.</li>
            <li><code>Quadrilateral</code> - four vertices (points) as parameters.</li>
            <li><code>Circle</code> - point of the center and double value of the radius.</li>
        </ul>
    Ensure figures are not degenerative.<br>
    All of them must have non-zero area.<br>
    Quadrilateral is also must be convex.<br>
    If a figure is not good, throw an IllegalArgumentException.<br>
    <em>Note:</em> A non-degenerative convex quadrilateral is divided into four non-degenerative triangles by its diagonals.<br> 
    <em>Note:</em> double calculations are not completely accurate, use <em>error delta</em>, where applies.<br>
    <li>2. <code>public Point centroid()</code><br></li>
    Return the centroid of the figure.<br>
    Centroid refers to center of mass of the plain figure, not the baricenter.<br>
    In other words it should be <em>"area centroid"</em>.<br>
    <li>3. <code>public boolean isTheSame(Figure figure)</code><br></li>
    Two figures are considered to be the same only:<br>
        <ul>
            <li>If they have the same type.</li>
            <li>And if they coincide (e.g. have same vertices).</li>
        </ul>
    <em>Note:</em> Order of the vertices have not to be the same.<br>
    <em>Note:</em> double calculations are not completely accurate, use <em>error delta</em>, where applies.<br>
    </ul>
    <em>Note for curious: it is almost like <code>equals()</code> but it is not. Method <code>equals</code> requires consistent behavior alongside <code>hashCode()</code> and it is quite complicated to establish in terms of approximate equality like in this exercise.</em><br>
    <code>Point</code> class is already there.<br>
    You may use <code>main</code>  method of <code>Figure</code>  class to try out your code.<br>
    Hints:<br>
    <ul>
      <li><a href="https://en.wikipedia.org/wiki/Degeneracy_(mathematics)">Degeneracy reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Quadrilateral#Convex_quadrilaterals">Convex quadrilateral reference</a></li>
      <li><a href="https://www.engineeringintro.com/mechanics-of-structures/centre-of-gravity/centroid-of-circle/">Circle centroid reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Centroid#Of_a_triangle">Triangle centroid reference</a></li>
      <li><a href="https://en.wikipedia.org/wiki/Quadrilateral#Remarkable_points_and_lines_in_a_convex_quadrilateral">Quadrilateral centroid reference</a></li>
      <li><a href="https://sites.math.washington.edu/~king/java/gsp/center-mass-quad.html">Quadrilateral centroid reference 2</a></li>
    </ul>
</details>

---

## Nested Classes

### [Contact Book](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_8_nested_classes/task_1_contact_book)
<details>
  <summary>Task</summary>
  <p>
    In this exercise we are going to manage contacts information.<br>
    A <code>Contact</code> is a class containing different information of how to reach a person or a company: phone number, emails, social media.<br>
    A contact has a name, which is provided via the class constructor. Also, a contact contains limited amount of entries:<br>
    <ul>
      <li>A phone number (only a single one).</li>
      <li>Emails (up to 3 entries).</li>
      <li>Social media links (up to 5 entries).</li>
    </ul>
    A contact info entry is described with <code>ContactInfo</code> interface. Each entry has a title and a value. You need to implemented them as nested classes of the <code>Contact</code> class:<br>
    <ul>
      <li><code>Contact.NameContactInfo</code> - A <code>ContactInfo</code> implementation providing the name of the contact. Implement as private non-static nested class. Use <code>"Name"</code> for the entry title. It must not have its own fields. It must use fields of the bounded <code>Contact</code> instance instead.</li>
      <li><code>Contact.Email</code> - A <code>ContactInfo</code> implementation containing an email. Implement as public static nested class. Use <code>"Email"</code> for the entry title.</li>
      <li><code>Contact.Social</code> - A <code>ContactInfo</code> implementation containing a social media link/id. Implement as public static nested class. Let the user of the class define the title.</li>
      <li>Other implementations must be anonymous. Do not provide other non-anonymous classes.</li>
    </ul>
    It is possible to add contact info entries via <code>add*</code> methods. All such methods return the created entry as the result, <code>null</code> if nothing was added to the contact.<br>
    <ul>
      <li><code>addEmail(String localPart, String domain)</code><br>
        Adds an email entry.<br>
        <code>addEmail("someone", "somewhere.com").getValue()</code> will result to <code>someone@somewhere.com.</code></li>
      <li><code>addEpamEmail(String firstname, String lastname)</code><br>
        Adds a special email entry with <code>"epam.com"</code> domain. Please, implement this method using an anonymous extension of the <code>Email</code> class. Use <code>"Epam Email"</code> for the entry title.<br>
        <code>addEpamEmail("some", "one").getValue()</code> will result to <code>some_one@epam.com</code></li>
      <li><code>addPhoneNumber(int code, String number)</code><br>
        Adds a contact info entry for the phone number. Please, implement this method using an anonymous class. Use <code>"Tel"</code> for the entry title.<br>
        <code>addPhoneNumber(44, "444 444-44-44").getValue()</code> will result to <code>+44 444 444-44-44</code></li>
      <li><code>addTwitter(String twitterId)</code><br>
        Adds a contact info entry for the Twitter social media id. Use <code>"Twitter"</code> for the entry title, the given id for the value.</li>
      <li><code>addInstagram(String instagramId)</code><br>
        Adds a contact info entry for the Instagram social media id. Use <code>"Instagram"</code> for the entry title, the given id for the value.</li>
      <li><code>addSocialMedia(String title, String id)</code><br>
        Adds a contact info entry for the generic social media id. Use the given title for the entry title, the given id for the value.</li>
    </ul>
    Note that it is possible to rename contact with the <code>rename</code> method. Make sure it is not possible to rename contact to have <code>null</code> or empty value as the name.<br>
    One more method that the <code>Contact</code> class have is the <code>getInfo()</code> method. This method returns an array containing the <code>ContactInfo</code> entries in the following order:<br>
    <ul>
      <li>Name contact info.</li>
      <li>Phone number contact info (if set).</li>
      <li>Email entries in order of addition (if any added).</li>
      <li>Social media entries in order of addition (if any added) Resulting array must not contain any null values.</li>
    </ul>
    <strong>Important restriction:</strong> Note that in this exercise you <strong>may not</strong> use <em>Collections</em> and <em>Streams</em>.<br>
</details>

### [Arithmetic Expressions](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_8_nested_classes/task_2_arithmetic_expressions)
<details>
  <summary>Task</summary>
  <p>
    In this exercise we are going to design a DSL of arithmetic expressions.<br>
    An <code>Expression</code> is an interface. It describes two methods:<br>
    <ul>
      <li><code>int evaluate()</code> - returns the result of evaluating of the expression.</li>
      <li><code>String toExpressionString()</code> - returns string representation of the expression.</li>
    </ul>
     The only non-anonymous implementation of the <code>Expression</code> is the <code>Variable</code> class. Please, implement its methods:<br>
    <ul>
      <li><code>public Variable(String name, int value)</code> - a constructor of the <code>Variable</code> class. Sets name and value of the variable.</li>
      <li><code>public void setValue(int value)</code> - a method to change the value of the variable.</li>
      <li><code>public int evaluate()</code> - returns the value of the variable.</li>
      <li><code>public String toExpressionString()</code> - returns the name of the variable.</li>
    </ul>
    All other implementations of the <code>Expression</code> interface must be anonymous, defined in static methods of the <code>Expressions</code> class:<br>
    <ul>
      <li><code>Variable var(String name, int value)</code> - returns a <code>Variable</code> with given name and value. A simple convenience method.</li>
      <li><code>Expression val(int value)</code> - returns an <code>Expression</code> holding a value. Consider following methods' implementation details:</li>
        <ul>
            <li><code>int evaluate()</code> - returns the given value.</li>
            <li><code>String toExpressionString()</code> - returns a string representation of the given value. Enclose with <code>(</code>, <code>)</code> braces if the value is negative.</li>
        </ul>
      <li><code>Expression sum(Expression... members)</code> - returns an <code>Expression</code> holding a sum of the given members. Consider that it is guaranteed that at least two members will be given each method call. Consider following methods' implementation details:</li>
        <ul>
            <li><code>int evaluate()</code> - returns the sum of evaluation result of all the given members.</li>
            <li><code>String toExpressionString()</code> - returns a string representation of the given sum. Example: <code>sum(val(1), val(2), val(3)).toExpressionString()</code> results to <code>(1 + 2 + 3)</code>.</li>
        </ul>
      <li><code>Expression product(Expression... members)</code> - returns an <code>Expression</code> holding a product of the given members. Consider that it is guaranteed that at least two members will be given each method call. Consider following methods' implementation details:</li>
        <ul>
            <li><code>int evaluate()</code> - returns the product of evaluation result of all the given members.</li>
            <li><code>String toExpressionString()</code> - returns a string representation of the given product. Example: <code>product(val(1), val(2), val(3)).toExpressionString()</code> results to <code>(1 * 2 * 3)</code>.</li>
        </ul>
      <li><code>Expression difference(Expression minuend, Expression subtrahend)</code> - returns an <code>Expression</code> holding a difference between the given minuend and the given subtrahend. Consider following methods' implementation details:</li>
        <ul>
            <li><code>int evaluate()</code> - returns the difference between the given minuend evaluation result and the given subtrahend evaluation result.</li>
            <li><code>String toExpressionString()</code> - returns a string representation of the given difference. Example: <code>product(val(1), val(2)).toExpressionString()</code> results to <code>(1 - 3)</code>.</li>
        </ul>
      <li><code>Expression fraction(Expression dividend, Expression divisor)</code> - returns an <code>Expression</code> holding a ratio of the given dividend to the given divisor. Note that it refers to an <em>integer</em> division operation, i.e. <code>fraction(val(3), val(4)).evaluate()</code> result to <code>0</code>. Consider following methods' implementation details:</li>
        <ul>
            <li><code>int evaluate()</code> - returns the ratio of the given dividend evaluation result to the given divisor evaluation result.</li>
            <li><code>String toExpressionString()</code> - returns a string representation of the given fraction. Example: <code>fraction(val(1), val(2)).toExpressionString()</code> results to <code>(1 / 2)</code>.</li>
        </ul>
    </ul>
    <strong>Important restriction:</strong> Note that in this exercise you <strong>may not</strong> add more non-anonymous classes.<br>
</details>

---

## Working with Strings

### [Words](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_9_working_with_strings/task_1_words)
<details>
  <summary>Task</summary>
  <p>
    Please, implement <code>StringUtil</code> class methods:<br>
    <strong>1. countEqualIgnoreCaseAndSpaces</strong><br>
    Method signature:<br>
    <code>public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample)</code><br>
    Return the number of words from <code>words</code> array that are equal to <code>sample</code> ignoring characters case and leading and trailing spaces.<br>
    If <code>sample</code> is <code>null</code> or <code>words</code> is <code>null</code> or empty, return <code>0</code>. <code>words</code> is guaranteed to not contain <code>null</code> values.<br>
    <strong>2. splitWords</strong><br>
    Method signature:<br>
    <code>public static String[] splitWords(String text)</code><br>
    Split <code>text</code> string into array of words using following separating characters: <code>",", ".", ";", ":", " ", "?", "!"</code>.<br>
    For empty string, <code>null</code> string, and string consisting only of separating characters return <code>null</code>.<br>
    <strong>3. convertPath</strong><br>
    Method signature:<br>
    <code>public static String[] splitWords(String text)</code><br>
    Convert <code>path</code> to Unix\Windows path depending on a boolean parameter.<br>
    Unix path may start with <code>~</code> or <code>/</code>. Every subdirectory must end with <code>/</code> character except the last one. Path elements <code>.</code> and <code>..</code> refer to current directory and parent directory. Filename doesn't necessarily have the extension.<br>
    Unix path examples:<br>
    <ul>
        <li><code>/folder/../folder/file.txt</code></li>
        <li><code>/dev/null</code></li>
        <li><code>file.txt</code></li>
        <li><code>folder/logs/</code></li>
        <li><code>~/user/some_logs</code></li>
    </ul>
    Windows path may start with <code>C:</code>. Every subdirectory must end with <code>\</code> character except the last one. <code>.</code> and <code>..</code> refer to current directory and parent directory. Filename doesn't necessarily have the extension.<br>
    Windows path examples:<br>
    <ul>
        <li><code>file.txt</code></li>
        <li><code>\Program Files\some_file.exe</code></li>
        <li><code>.\to_do_list.txt</code></li>
        <li><code>C:Users\..\Cygwin\</code></li>
        <li><code>.\file</code></li>
    </ul>
    Let's consider Unix <code>~</code> path to correspond to Windows <code>C:\User</code> path and vice versa.<br>
    Let's consider Unix <code>/</code> root folder (i.e., when the path starts with <code>/</code>) to correspond to Windows <code>C:\</code> drive and vice versa (but <code>C:\User</code> still corresponds to <code>~</code>).<br>
    If <code>path</code> already corresponds to the required format (for instance, is Windows path when Windows paths is needed and <code>toWin</code> boolean parameter is <code>true</code>) return <code>path</code>.<br>
    If <code>path</code> is <code>null</code>, empty, or doesn't correspond to any path format (Unix, Windows), return <code>null</code>.<br>
    It is guaranteed that <code>path</code> is either a correct path, or it has some of the following errors:<br>
    <ul>
        <li>More than one <code>~</code></li>
        <li><code>~</code> is not at the start</li>
        <li><code>~</code> mixed with <code>\</code> (<code>~</code> in Windows path)</li>
        <li>More than one <code>C:</code></li>
        <li><code>C:</code> is not at the start</li>
        <li><code>C:</code> mixed with <code>/</code> (<code>C:</code> in Unix path)</li>
        <li><code>\</code> mixed with <code>/</code></li>
    </ul>
    Illegal paths example:<br>
    <ul>
        <li><code>/folder1/folder2\folder3</code></li>
        <li><code>C:\User/root</code></li>
        <li><code>/dev/~/</code></li>
        <li><code>C:/a/b/c/d</code></li>
        <li><code>~\folder</code></li>
        <li><code>~/~</code></li>
        <li><code>~~</code></li>
        <li><code>C:\Folder\Subfolder\C:\</code></li>
    </ul>
    <strong>4. joinWords</strong><br>
    Method signature:<br>
    <code>public static String joinWords(String[] words)</code><br>
    Join <code>words</code> from words array and return as a string in the following format: "<code>[str_1, str_2, ..., str_n]</code>".<br>
    If <code>words</code> is <code>null</code> or empty return <code>null</code>. <code>words</code> is guaranteed to not contain <code>null</code> values. <code>words</code> may contain empty strings, ignore them, i. e. don't put them in the resulting string. If <code>words</code> contains only empty strings return <code>null</code>.<br>
    <strong>Hints</strong><br>
    <ul>
        <li>While implementing the methods you might need to come up with <code>regular expressions</code>. You may consider using <a href=https://regex101.com/">regex101.com</a> to easier design of regular expressions.</li>
        <li>You can and should use following methods\classes (click on the name):</li>
        <ul>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#strip()">String.strip</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#split(java.lang.String)">String.split</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#replaceAll(java.lang.String,java.lang.String)">String.replaceAll</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#replaceFirst(java.lang.String,java.lang.String)">String.replaceFirst</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#toLowerCase()">String.toLowerCase</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#equalsIgnoreCase(java.lang.String)">String.equalsIgnoreCase</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#startsWith(java.lang.String)">String.startsWith</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#matches(java.lang.String)">String.matches</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#join(java.lang.CharSequence,java.lang.CharSequence...)">String.join</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/StringBuilder.html">StringBuilder</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/StringJoiner.html">StringJoiner</a></li>
            <li><a href=https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/StringTokenizer.html">StringTokenizer</a></li>
        </ul>
    </ul>
</details>

### [Validations. Color Code](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_9_working_with_strings/task_2_validations_color_code)
<details>
  <summary>Task</summary>
  <p>
    Please, implement <code>validateColorCode</code> method in <code>ColorCodeValidation</code>:<br>
    This method checks the input string for compliance with the rules for writing <a href=https://htmlcolorcodes.com/">HTML Color Codes </a>.<br>
    While implementing the methods you might need to come up with regular expressions. You may consider using <a href=https://regex101.com/">regex101.com</a> to ease designing them.<br>
    You can and should use following methods\classes:<br>
    <ul>
        <li><code>matches</code></li>
        <li><code>Pattern</code></li>
        <li><code>Matcher</code></li>
    </ul>
</details>

### [Validations. Epam email](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_9_working_with_strings/task_3_validations_epam_email)
<details>
  <summary>Task</summary>
  <p>
    Please, implement <code>validateEpamEmail</code> method in <code>EpamEmailValidation</code>:<br>
    This method checks the input string for compliance with the rules for a regular EPAM email. Let us define them:<br>
    <ul>
        <li>A regular EPAM email includes firstname and lastname (in English), separated by underscore ("_").</li>
        <li>EPAM email always ends with "@epam.com"</li>
        <li>When a person gets new EPAM email, but email with this firstname and lastname is already registered, we add "1" to the new email. If such email is registered as well, we use "2" and so on.</li>
    </ul>>
    While implementing the method you might need to come up with regular expressions. You may consider using <a href=https://regex101.com/">regex101.com</a> to ease designing them.<br>
    You can and should use following methods\classes:<br>
    <ul>
        <li><code>matches</code></li>
        <li><code>Pattern</code></li>
        <li><code>Matcher</code></li>
    </ul>
</details>

---

## Exceptions

### [Requirements](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_10_exceptions/task_1_requirements)
<details>
  <summary>Task</summary>
  <p>
    Please, implement Requirements methods:<br>
    <ul>
      <li><code>requireNonNull(Object)</code> should throw new NullPointerException if object is null.</li>
      <li><code>requireNonNull(Object, String)</code> should throw new NullPointerException with message if object is null.</li>
      <li><code>checkArgument(boolean)</code> if boolean is false should throw new IllegalArgumentException.</li>
      <li><code>checkArgument(boolean, String)</code> if boolean is false should throw new IllegalArgumentException with message.</li>
      <li><code>checkState(boolean)</code> if boolean is false should throw new IllegalStateException.</li>
      <li><code>checkState(boolean, String)</code> if boolean is false should throw new IllegalStateException with message.</li>
      <li><code>checkElementIndex(int, int)</code> if index out of bounds throw new IndexOutOfBoundsException.</li>
    </ul>
    Such methods might be helpful to check arguments, object states.
</details>

### [Catch'em all](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_10_exceptions/task_2_%D1%81atch_em_all)
<details>
  <summary>Task</summary>
  <p>
    Please, implement the main method in CatchEmAll class. It must handle a call to a risky method that can throw different types of exceptions.<br>
    Please, note that some types of exceptions should be handled, while others – shouldn’t.<br>
    Details:<br>

| What is thrown                               | How to handle                                                                         |
|----------------------------------------------|---------------------------------------------------------------------------------------|
| IOException                                  | Wrap in an IllegalArgumentException with a message "Resource error" and throw it      |
| FileNotFoundException                        | Wrap in an IllegalArgumentException with a message "Resource is missing" and throw it |
| ArithmeticException or NumberFormatException | Print a message of the thrown exception to System.err and do not throw anything       |
| Any other Exceptions                         | Should not be caught                                                                  |

</details>

---

## Generics

### [Beware of Dogs](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_12_generics/task_1_beware_of_dogs)
<details>
  <summary>Task</summary>
  <p>
    Please, use generics to change <code>House</code> class in order to dogs cannot enter cats' house and cats cannot enter dogs' house.<br>
    You need to alter <code>residents</code> field and <code>enter</code> methods of the <code>House</code> class.<br>
    Note that if you have done everything right, then two particular lines in the <code>Main</code> class will prevent successful compilation, so you need to remove them. See details in the <code>Main</code> class.<br>
</details>

---

## Enums

### [Compass](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_13_enums/task_1_compass)
<details>
  <summary>Task</summary>
  <p>
    Please, implement methods in Direction class:<br>
    <ul>
        <li><code>ofDegrees</code> - Return a Direction instance by input degrees or empty Optional if there is none.</li>
        <li><code>closestToDegrees</code> - Return the closest Direction instance to input degrees.</li>
        <li><code>opposite</code> - Return a Direction instance that is opposite to this.</li>
        <li><code>differenceDegreesTo</code> - Return the difference in degrees between this and input Direction instance.</li>
    </ul>
</details>

---

## Wrapper Classes

### [Battleship 8x8](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_14_wrapper_classes/task_1_battleship8x8)
<details>
  <summary>Task</summary>
  <p>
    Please, implement methods in Battleship8x8 class.<br>
    Battleship8x8 represents a 8x8 map for <a href=https://en.wikipedia.org/wiki/Battleship_(game)">Battleship game </a>. An important detail is that Battleship8x8 uses a <code>ships</code> field of long type to store ships locations and a <code>shots</code> field of long type to register shots.<br>
    Fields of long type value store 64 bits each. Consider them as 8 rows per 8 cells. '0' bits represent empty cells, '1' bits represent cells seized by ships or registered shots.<br>
    <ul>
        <li><code>public boolean shoot(String shot)</code> - Registers a shot and returns <code>true</code> if the shot hits a ship. A shot is a combination of one of A-H letters and one of 1-8 digits.</li>
        <li><code>public String state()</code> - Returns a string representing state of the map. Map string is 8 lines per 8 characters separated by "\n". Use following symbols:</li>
            <ul>
                <li>'.' - an empty cell</li>
                <li>'×' - an empty cell that has been shot</li>
                <li>'☐' - a cell seized by a ship</li>
                <li>'☒'- a cell seized by a ship that has been shot</li>
            </ul>
    </ul>
    You must not add or change new fields. Consider using static methods of wrapper classes.
</details>

---

## Optional

### [Optional Max](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_15_optional/task_1_optional_max)
<details>
  <summary>Task</summary>
  <p>
    Implement <code>max</code> method of <code>MaxMethod</code> class.<br>
    The correct implementation should receive an array of <code>int</code> values and return its maximum value.<br>
    Details:<br>
    <ul>
        <li>the method returns the result as OptionalInt</li>
        <li>if the input array is empty or <code>null</code>, return empty OptionalInt.</li>
    </ul>
</details>

---

## Introduction to Collections

### [Introduction to Collections](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_16_introduction_to_collections/task_1_iterating_collections)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will simulate the work of a new post office that takes parcels weighing between 0.5 and 20 kg and with a maximum volume of 0.25 м3.<br>
    The <code>Box</code> class describes parcels. A parcel has the following characteristics: sender, recipient, weight, volume, and shipping cost. All characteristics except for the shipping cost are passed to the constructor to create an object. The shipping cost is calculated based on the weight, volume, and value of the parcel.<br>
    The <code>NewPostOffice</code> class has:<br>
    <ul>
      <li><code>NewPostOffice()</code><br>
          Creates an office (an empty collection of parcels)</li>
      <li><code>Collection&lt;Box&gt; getListBox()</code><br>
          Returns a collection of parcels in the office</li>
      <li><code>static BigDecimal calculateCostOfBox(double weight, double volume, int value)</code><br>
          Calculates the cost of a parcel</li>
    </ul>
    Please proceed to the NewPostOffice class and implement its methods using an iterator:<br>
    <ul>
      <li><code>Collection&lt;Box&gt; deliveryBoxToRecipient(String recipient)</code><br>
          Returns all parcels of a specified recipient; any parcels found must be removed from the office</li>
      <li><code>void declineCostOfBox(double percent)</code><br>
          Changes the cost of each parcel in the office by the percentage specified</li>
      <li><code>boolean addBox(String sender, String recipient, double weight, double volume, int value)</code><br>
          Creates a parcel, calculates its shipping cost, and adds it to the office</li>
    </ul>
    <strong>Details:</strong><br>
    <ul>
        <li>The sender and receiver must exist.</li>
        <li>The weight must be 0.5–20.0 kg.</li>
        <li>The volume must be greater than 0 and less than 0.25 m3.</li>
        <li>The value must be greater than zero.</li>
        <li>The cost of a parcel is calculated as follows: the weight is multiplied by the cost of one kilogram, the volume is multiplied by the cost of one cubic meter, the value is multiplied by a given coefficient, then everything is summed up.</li>
        <li>If the values of the data above are set incorrectly (by specifying invalid values), the java.lang.IllegalArgumentException is thrown.</li>
    </ul>
    <strong>Restriction:</strong><br>
    You may not use the Lambdas or the Streams API.
</details>

---

## Lists And Queues

### [Simple Array List](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_17_lists_and_queues/task_1_simple_array_list)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will describe a list that is based on a dynamic array. The internal structure of the list is a one-dimensional array of the <code>Object</code> type with an initial capacity/size of 10 and a size field that stores the number of elements in the list. You must provide for the expansion of the array (list) capacity when the number of elements reaches 75% (load factor 0.75) of its size. Use the following expression to calculate the increase in capacity: Doub le the current capacity of the array and then multiply it by the load factor.<br>
    Now, please proceed to the <code>SimpleArrayListImpl</code> class, which implements the <code>SimpleArrayList</code> interface, and provide implementations of the following methods:<br>
    <ul>
        <li><code>int size()</code><br>
          Returns the number of elements</li>
        <li><code>String toString()</code><br>
          Makes a string representation of the list</li>
        <li><code>boolean add(Object element)</code><br>
          Appends the specified element to the end of the list</li>
        <li><code>Object get(int index)</code><br>
          Returns an element at a specified position in the list</li>
        <li><code>Optional&lt;Object&gt; remove(Object element)</code><br>
          Searches for and removes the specified element</li>
        <li><code>int capacity()</code><br>
          Returns the current length of the list</li>
        <li><code>boolean decreaseCapacity()</code><br>
          Decreases the capacity of the list if it is 40% full or less</li>
    </ul>
    <strong>Details:</strong><br>
    <ul>
        <li>The list is created by the default constructor, which creates an internal array with an initial length of 10 elements.</li>
        <li>The list cannot contain <code>null</code> elements. The add and remove methods must throw a <code>NullPointerException</code> if they get null.</li>
        <li>The get method must throw <code>IndexOutOfBoundsException</code> if the index is outside the [0 … size - 1] range.</li>
        <li>The size field specifies the number of elements in the list and where to place the next element.</li>
        <li>The method for adding a new element must first check whether the capacity of the list should be increased before adding it.</li>
        <li>The <code>decreaseCapacity()</code> method calculates the new capacity by doubling the current number of elements.</li>
        <li>You can add any private methods to the <code>SimpleArrayListImp</code> class.</li>
    </ul>
    <strong>Restrictions:</strong><br>
    You may not:<br>
    <ul>
        <li>Use any type from the <code>java.util</code> package (or its subpackages) except for:<br>
            * <code>java.util.Iterator</code><br>
            * <code>java.util.Optional</code></li>
        <li>Add any additional fields into the <code>SingleArrayListImpl</code> class.</li>
        <li>Add any additional public methods to the <code>SingleArrayListImpl</code> class.</li>
    </ul>
</details>


### [Doubly Linked List](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_17_lists_and_queues/task_2_doubly_linked_list)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will describe a bidirectional list based on a linked representation. The internal structure of the list is a node chain (nested class <code>Node</code>) where each node encapsulates a list element and has one reference to the previous node and one reference to the following node. The first node has no reference to the previous node, and the last node has no reference to the next one.<br>
    Now, please proceed to the <code>DoublyLinkedListImpl</code> class, which implements the <code>DoublyLinkedList</code> interface, and provide implementations of the following methods:<br>
    <ul>
        <li><code>boolean addFirst(Object element)</code><br>
          Inserts an element at the beginning of the list and returns true if an element is successfully added and, if not, false</li>
        <li><code>boolean addLast(Object element)</code><br>
          Appends an element to the end of this list and returns true if an element is successfully added and, if not, false</li>
        <li><code>boolean delete(int index)</code><br>
          Deletes an element by index and throws <code>IndexOutOfBoundsException</code> if the index is out of range</li>
        <li><code>Optional&lt;Object&gt; remove(Object element)</code><br>
          Returns and deletes the first occurrence of the specified element in the list</li>
        <li><code>boolean set(int index, Object element)</code><br>
          Finds the element at the specified index and replaces it or throws the <code>IndexOutOfBoundsException</code> if the index is out of range</li>
        <li><code>int size()</code><br>
          Returns the number of elements in the list</li>
        <li><code>Object[] toArray()</code><br>
          Returns an array containing all the elements in order from first to last</li>
        <li><code>String toString()</code><br>
          Returns a string representation of the list</li>
    </ul>
    <strong>Details:</strong><br>
    <ul>
        <li>The <code>DoublyLinkedListImpl</code> class has two fields, head and tail, and should not contain a size field to store the number of elements.</li>
        <li>The list is created by the default constructor, which initializes the head and tail fields to null.</li>
        <li>The list cannot contain null elements. The add, remove, and set methods must throw a <code>NullPointerException</code> if they get null.</li>
        <li>The remove method must use the equals method to find the occurrence of the object in the list.</li>
        <li>The string representation of a list consists of all its elements separated by a space. For example, if a list contains three elements, o1, o2, and o3, the <code>toString</code> method returns "s1 s2 s3", where <code>s1=o1.toString()</code>, <code>s2=o2.toString()</code>, and <code>s3=o3.toString()</code>.</li>
    </ul>
    <strong>Restrictions:</strong><br>
    You may not:<br>
    <ul>
        <li>Use any type from the <code>java.util</code> package or its subpackages except for <code>java.util.Optional</code></li>
        <li>Add additional fields to the <code>DoublyLinkedListImpl</code> and <code>DoublyLinkedListImpl.Node</code> classes</li>
        <li>Add any additional methods to the <code>DoublyLinkedListImpl.Node</code> class except constructors</li>
    </ul>
</details>

### [New Post Office Storage](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_17_lists_and_queues/task_3_new_post_office_storage)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will simulate the work of the New Post Storage service, which accepts parcels (boxes) and prepares them for distribution to New Post offices. The <code>Box</code> class describes a parcel with the following characteristics: <code>sender</code>, <code>recipient</code>, <code>weight</code>, <code>volume</code>, <code>cost</code>, <code>city</code>, and <code>office</code>. All characteristics are passed to the constructor to create an object. You must not change this class.<br>
    The <code>NewPostOfficeStorage</code> interface has several methods that perform <code>add</code>, <code>delete</code>, <code>filter</code>, and <code>update</code> operations in a storage:<br>
    <ul>
        <li><code>boolean acceptBox(Box box)</code><br>
           Appends the specified parcel to the end of this storage</li>
        <li><code>boolean acceptAllBoxes(Collection&lt;Box&gt boxes)</code><br>
          Appends to this storage all parcels that are contained in the specified collection. It must add either all the parcels or nothing, if an exception occurs</li>
        <li><code>boolean carryOutBoxes(Collection&lt;Box&gt boxes)</code><br>
          Removes from this storage all of its parcels that are contained in the specified collection</li>
        <li><code>List&lt;Box&gt carryOutBoxes(Predicate&lt;Box&gt predicate)</code><br>
          Removes from this storage all of its parcels that are satisfied the specified predicate</li>
        <li><code>List&lt;Box&gt getAllWeightLessThan(double weight)</code><br>
          Selects all parcels whose weight is less than the parameter value.</li>
        <li><code>List&lt;Box&gt getAllCostGreaterThan(BigDecimal cost)</code><br>
          Selects all parcels whose cost is greater than the parameter value.</li>
        <li><code>List&lt;Box&gt getAllVolumeGreaterOrEqual(double volume)</code><br>
          Selects all parcels whose volume is greater than or equal to the parameter value</li>
        <li><code>List&lt;Box&gt searchBoxes(Predicate&lt;Box&gt predicate)</code><br>
          Searches parcels using a predicate. This method does not change the original storage</li>
        <li><code>void updateOfficeNumber(Predicate&lt;Box&gt predicate, int newOfficeNumber)</code><br>
          Updates the <code>office</code> field in each box of this storage</li>
    </ul>
    Please, proceed to the <code>NewPostOfficeStorageImpl</code> that the implementor of <code>NewPostOfficeStorage</code> interface.<br>
    Its highly recommended avoid indexed access to elements of a collection.<br>
    The <code>Main</code> class is not under tests. You can use it for your own purposes.<br>
    <strong>Restrictions:</strong><br>
    <ul>
        <li>Because the <code>Box</code> class does not have any identity field the implementation <strong>must not check uniqueness</strong> of <code>Box</code> instances.</li>
        <li>Because the <code>NewPostOfficeStorage</code> describes business logic not a collection, an implementation <strong>must not extend</strong> any existing implementation of <code>List</code> interface or implement it internally <strong>but must aggregate</strong> it instead.</li>
        <li>You should choose the best existing implementation of the <code>java.util.List</code> interface from the Java collection framework.</li>
        <li>The implementation <strong>must not permit null values</strong> and must throw <code>NullPointerException</code> in such cases.</li>
        <li>It is forbidden to use:</li><br>
            <ul>
                <li>lambda when you implement functional interfaces.</li>
                <li><code>stream()</code>, <code>contains()</code>, <code>containsAll()</code> <code>indexOf()</code> methods of <code>List</code> interface.</li>
                <li><code>for ( i )</code> loop (use a <code>foreach</code> loop or <code>Iterator</code> with a <code>while()</code> loop or the <code>foreach()</code> method instead).</li>
            </ul>
    </ul>
</details>

---

## Sets

### [Ranged Ops Integer Set](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_18_sets/task_1_ranged_ops_integer_set)
<details>
  <summary>Task</summary>
  <p>
    In this task, you need to demonstrate how to work with a set of integers encapsulated in the <code>RangedOpsIntegerSet</code> class.<br>
    Please proceed to the RangedOpsIntegerSet class and provide implementations of the following methods:<br>
    <ul>
      <li><code>boolean add(final Integer integer)</code><br>
            Adds a single value to the set</li>
      <li><code>boolean remove(final Object o)</code><br>
            Removes a single value from the set</li>
      <li><code>boolean add(int fromInclusive, int toExclusive)</code><br>
            Adds a range of values to the set (first argument—inclusive; last argument—exclusive); returns true if range values were actually added</li>
      <li><code>boolean remove(int fromInclusive, int toExclusive)</code><br>
            Removes a range of values from the list (first argument—inclusive; last argument—exclusive); returns true if range values were actually removed</li>
      <li><code>Iterator&lt;Integer&gt iterator()</code><br>
            Returns an iterator to iterate over elements of the set in natural order</li>
      <li><code>int size()</code><br>
            Returns the number of current elements</li>
    </ul>
    <strong>Restrictions</strong><br>
    You may not use lambdas or streams when implementing this task.
</details>

### [Project skills](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_18_sets/task_2_project_skills)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will determine the percentage of compliance of a certain team with project requirements. In other words, you will determine if the team is suitable for the project.<br>
    You have the following description:<br>
    <ul>
        <li>The <code>Position</code> enum defines a set of positions.</li>
        <li>The <code>Skill</code> enum defines a set of skills.</li>
        <li>The <code>Level</code> enum defines a set of skill levels.</li>
        <li>The <code>Member</code> class defines a team member. Each member has a name, a level, and a set of skills (a collection of the <code>Set&lt;Skill&gt</code> type implemented as <code>EnumSet&lt;Skill&gt</code>). TThe team is described as a set of members in the form of <code>HashSet&lt;Member&gt</code>.</li>
        <li>The <code>Role</code> class defines the role of the participant in the project. Each role has a level, a position, and required skills (a collection of the <code>Set&lt;Skill&gt</code> type implemented as an <code>EnumSet&lt;Skill&gt</code>).</li>
        <li>The <code>Project</code> class defines the project and contains a description of it and a list of roles.</li>
        <li>The <code>Project.Entry</code> class combines a skill and its level and is used in the algorithm for calculating the team's compliance with the project.</li>
    </ul>
    Now, please proceed to the <code>Member</code> class and implement its contents:<br>
    <ul>
        <li><code>public Member(String name, Level level, Skill... skills)</code><br>
            Creates a member with the specified name, level, and skills</li>
        <li><code>Getters</code><br>
            Return values of the appropriate fields</li>
    </ul>
    Now, please proceed to the <code>Role</code> class and implement its contents:<br>
    <ul>
        <li><code>public Role(Position position, Level level, Skill... skills)</code><br>
            Creates a role with the specified position, level, and skills</li>
        <li><code>Getters</code><br>
            Return values of the appropriate fields</li>
    </ul>
    Now, please proceed to the <code>Project</code> class and implement its contents:<br>
    <ul>
        <li><code>public Project(Role... roles)</code><br>
            Creates a project with the specified roles</li>
        <li>public List&lt;Role&gt getRoles()<br>
            Returns a list of roles</li>
        <li><code>public int getConformity(Set&lt;Member&gt team)</code><br>
            Returns the percentage of team compliance with the project requirements</li>
        <li><code>private static class Entry {}</code><br>
            Describes an entry containing a level/skill pair</li>
    </ul>
    <strong>Details:</strong><br>
    <ul>
        <li>The <code>Entry</code> must implement the equals and <code>hashCode</code> methods. Two entries are considered equal if and only if they have the same skill and level.</li>
        <li>To calculate the percentage of team compliance with project requirements, you must use the following algorithm:</li>
        <ul>
            <li>Generate a list of pairs <code>&lt;Level, Skill&gt</code> for the project's roles (e.g., named projectEntries).</li>
            <li>Save the size of this list to a variable (e.g., originalSize).</li>
            <li>Generate a list of pairs <code>&lt;Level, Skill&gt</code> for the team members (e.g., named teamEntries.</li>
            <li>Remove common elements from both lists.</li>
            <li>Calculate the compliance percentage as follows:</li>
            <ul>
                <li>Subtract the current size of the list of entries for the project roles from the originalSize variable</li>
                <li>Multiply the difference by 100</li>
                <li>Divide by the original size of the list of entries for the project roles</li>
            </ul>
        </ul>
    </ul> 
    <strong>Restrictions</strong><br>
    You may not:<br>
    <ul>
        <li>Add extra fields to classes</li>
        <li>Add extra methods to classes</li>
        <li>Use lambdas or streams when implementing this task</li>
    </ul>
</details>

---

## Maps

### [Books Catalog](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_19_maps/task_1_books_catalog)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will simulate work with a book catalog. The catalog can be represented as the <code>TreeMap</code> collection, where the author is the key and the list of published books is the value. You have the following description:<br>
    <ul>
      <li>The <code>Author</code> class, which consists of the first and last name</li>
      <li>The <code>Book</code> class, which consists of the title, genre, and cost</li>
    </ul>
    Since the book catalog is an ordered map, the <code>Author</code> and <code>Book</code> classes must implement the <code>Comparable</code> interface. The <code>BooksCatalog</code> class must have two constructors: a default one and one with a parameter that creates a map based on an existing map.<br>
    Please proceed to the <code>Author</code> and <code>Book</code> classes and provide implementations of the <code>compareTo()</code> method.<br>
    Please, proceed to the <code>BooksCatalog</code> class and provide implementations of the following methods:<br>
    <ul>
      <li><code>List&ltBook&gt findByAuthor(Author author)</code><br>
            Returns a list of books by the specified author or <code>null</code> if there is no such author in the catalog</li>
      <li><code>List&ltAuthor&gt findAuthorsByBook(Book book)</code><br>
            Returns a list of the authors of the specified book or <code>null</code> if there is no such book in the catalog</li>
      <li><code>String getAllAuthors()</code><br>
            Returns a list of all the authors as a String</li>
      <li><code>Set&ltBook&gt findBooksByGenre(String pattern)</code><br>
            Returns a set of books of the specified genre or <code>null</code> if there are no books of this genre</li>
      <li><code>Map&ltBook, List&ltAuthor&gt&gt findAuthorsByBookTitle(String pattern)</code><br>
            Returns the book/author pair map. The search is carried out based on the words in the book's title</li>
    </ul>
    <strong>Details</strong><br>
    <ul>
        <li>To order the map by author, apply alphabetical order by first name and, if the names match, alphabetical order by last name.</li>
        <li>To order the map by book title, apply alphabetical order by title and, if the titles match, by ascending cost.</li>
        <li>The <code>findAuthorsByBookTitle</code> method searches for books based on a word pattern; it is case-insensitive.</li>
        <li>The <code>findBooksByGenre</code> method searches for books of a certain genre specified as a search pattern; the matching pattern and name of the genre are case-insensitive; all the books found are sorted using natural ordering.</li>
        <li>You can use a regular expression to match occurrences of a pattern in a book title or genre in the <code>findBooksByGenre</code> and <code>findAuthorsByBookTitle</code> methods.</li>
        <li>The <code>getAllAuthors</code> method returns an alphabetical list of authors as a String, where the authors' names are separated by '\n'.</li>
        <li>No methods of the <code>BooksCatalog</code> class accept <code>null</code>, and they must throw a <code>NullPointerException</code> if they do.</li>
        <li>You can use the <code>getData()</code> method in the Util class to create the initial map.</li>
        <li>You can add any private methods to the <code>BooksCatalog</code> class.</li>
    </ul>
    <strong>Restrictions</strong><br>
    You may not use lambdas or streams when implementing this task.
</details>

---

## Collection Algorithms

### [Student’s Gradebook](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_20_collection_algorithms/task_1_students_gradebook)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will simulate the work of the student's gradebook. The internal structure of the gradebook is a collection of the <code>TreeMap</code> type where a key is an object of the <code>Student</code> type, the value is a <code>HashMap</code> whose key is the name of a discipline (an object of the <code>String</code> type), and the value is the grade (an object of the <code>BigDecimal</code> type).<br>
    The <code>Student</code> class describes a student with the following characteristics: <code>first/last</code> name and <code>group</code>. All characteristics are passed to the constructor to create an object. <strong>You must not change this class</strong>.<br>
    Now, please proceed to the <code>StudentsGradebookImpl</code> class, which implements the <code>StudentsGradebook</code> interface, and provide implementations of the following methods:<br>
    <ul>
      <li><code>public GradeBookImpl()</code><br>
            Creates the gradebook object in which a <code>Comparator</code> is described to compare students</li>
      <li><code>boolean addEntryOfStudent(Student student, String discipline, BigDecimal grade)</code><br>
            Adds a student entry to the gradebook; returns true if the addition was successful, and false if not.</li>
      <li><code>int size()</code><br>
            Returns the number of students in the gradebook</li>
      <li><code>Comparator&ltStudent&gt getComparator()</code><br>
            Returns the <code>Comparator</code>, which is used to compare students</li>
      <li><code>List&ltString&gt getStudentsByDiscipline(String discipline)</code><br>
            Gets a list of strings with students' names and their grades for the specified disciplines in the format <code>"first_last name : grade"</code></li>
      <li><code>Map&ltStudent, Map&ltString, BigDecimal&gt&gt removeStudentsByGrade(BigDecimal grade)</code><br>
            Finds, removes, and returns from the gradebook students who have a grade below the specified one in any discipline<br>
            If no such students are found, an empty map will be returned</li>
      <li><code>Map&ltBigDecimal, List&ltStudent&gt&gt getAndSortAllStudents()</code><br>
            Gets the gradebook as an ordered map where the key is the average grade and the value is a list of the <code>Student</code> type</li>
    </ul>
    <strong>Details</strong><br>
    <ul>
        <li>Since the <code>Student</code> objects are the keys to the gradebook, when you create the gradebook, you will need to declare the <code>Comparator</code> to compare objects of the <code>Student</code> type and pass it to the <code>TreeMap&ltStudent, Map&ltString, BigDecimal&gt&gt</code> constructor.</li>
        <li>The grading scale for any discipline is in the range <code>[0 .. 5]</code>. The minimum passing grade is 3 points.</li>
        <li>The <code>removeStudentsByGrade</code> method returns a map ordered by the <code>Student</code> type. To create the resulting map, you must use the <code>Comparator</code> applied in the gradebook constructor.</li>
        <li>The <code>getAndSortAllStudents</code> method generates a gradebook based on the student's average grade. The average grade is indicated in increments of one tenth—for example, 3.1, 3.2, 3.3, etc.</li>
        <li>It is guaranteed that the parameters passed to all methods are correct.</li>
        <li>You can add any private methods to the <code>StudentsGradebookImpl</code> class.</li>
    </ul>
    <strong>Restrictions:</strong><br>
    You may not use lambdas or streams to complete this task.
</details>

### [Maternity Hospital Journal](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_20_collection_algorithms/task_2_maternity_hospital_journal)
<details>
  <summary>Task</summary>
  <p>
    In this task, you will simulate the work of a weekly maternity hospital journal. The internal structure of the journal is a collection of the <code>Map</code> type, where the key is the weekday (an enum of the <code>WeekDay</code> type) and the value is a list of babies born during the week (objects of the <code>Baby</code> type).<br>
    The <code>Baby</code> class describes a baby with the following characteristics: <code>name</code>, <code>weight</code>, <code>height</code>, <code>gender</code>, and <code>birth time</code>. All characteristics are passed to the constructor to create an object. <strong>You must not change this class</strong>.<br>
    Please note that once a birth journal has been created and filled in, it cannot be changed. This needs to be guaranteed.<br>
    Now, please proceed to the <code>BirthJournalManagementImpl</code> class, which implements <code>the BirthJournalManagement</code> interface, and provide implementations of the following methods:<br>
    <ul>
      <li><code>boolean addEntryOfBaby(WeekDay day, Baby baby)</code><br>
            Adds an entry for the specified baby to the journal; returns true if the addition was successful and false if not</li>
      <li><code>void commit()</code><br>
            Makes the journal immutable</li>
      <li><code>int amountBabies()</code><br>
            Returns the number of babies born in a given week</li>
      <li><code>List&ltBaby&gt findBabyWithHighestWeight(String gender)</code><br>
            Finds the baby of the specified gender with the highest weight<br>
            If there are multiple babies, it sorts them alphabetically by name.</li>
      <li><code>List&ltBaby&gt findBabyWithSmallestHeight(String gender)</code><br>
            Finds the baby of the specified gender with the smallest height<br>
            If there are multiple babies, it sorts them in order of increasing weight</li>
      <li><code>Set&ltBaby&gt findBabiesByBirthTime(String from, String to)</code><br>
            Finds babies born in the specified time period</li>
    </ul>
    <strong>Details</strong><br>
    <ul>
        <li>Time of birth is given as a <code>String</code> in the form <code>"hour:minute"</code>.</li>
        <li>For implementations of all methods, the parameters passed to them are guaranteed to be correct.</li>
        <li>You can add any private methods to the <code>BirthJournalManagementImpl</code> class.</li>
    </ul>
    <strong>Restrictions:</strong><br>
    You may not use lambdas or streams to complete this task.
</details>

---

## Introduction to I/O Streams

### [License Reader](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_21_introduction_to_i_o_streams/task_1_license_reader)
<details>
  <summary>Task</summary>
  <p>
    In this task you will implement <code>LicenseReader#collectLicenses(File, File)</code> method. It must read all license files from <code>root</code>, format these licenses to a specific format and write all of them into <code>outputFile</code>. <code>root</code> might be a directory or just a regular file. Please note that you need to collect files not only from the root directory, but also from its subdirectories and their subdirectories, etc. All non-license files must be ignored. Be aware, that this method must not throw any checked exception.<br>
    Take a look at the license header format:<br>
    <code>---</code><br>
    <code>License: &ltlicense name&gt</code><br>
    <code>Issued by: &ltissuer&gt</code><br>
    <code>Issued on: &ltdate&gt</code><br>
    <code>Expires on: &ltdate&gt</code><br>
    <code>---</code><br>
    The order of these properties is not restricted, so you may expect that <code>Expires</code> on might occur earlier than <code>License</code>. All of them are mandatory except for <code>Expires on</code>. The date format is ISO date <code>(yyyy-mm-dd)</code>. The license is wrapped between lines containing 3 dashes (<code>---</code>). The file always starts with license header, otherwise it's just a regular file.<br>
    If license header is invalid, then <code>IllegalArgumentException</code> must be thrown. If either <code>root</code> or <code>outputFile</code> is null, then <code>IllegalArgumentException</code> must be thrown. If <code>root</code> does not exist, or it's not readable, then the same exception must be thrown. And if <code>root</code> is a directory, but is not executable (means that it could not be entered), then <code>IllegalArgumentException</code> must be thrown.<br>
    The output format for just one license looks like:<br>
    <code>License for &ltfile name&gt is &ltlicense name&gt issued by &ltissuer&gt [&ltissuedOn date&gt - &ltexpiresOn date&gt]</code><br>
    Each line must contain the information about license in this format. If license does not have an expiration date, then instead of <code>&ltexpiresOn date&gt - unlimited</code> must be used.<br>
    If <code>outputFile</code> exists, then it must be cleared. So no appending is allowed.<br>
<strong>Requirements</strong><br>
    <ul>
        <li><code>collectLicenses</code> method must verify that <code>root</code> is:</li>
        <ul>
            <li>not null</li>
            <li>exists</li>
            <li>readable</li>
            <li>if it's a directory, then that it's executable</li>
        </ul>
        <li><code>collectLicenses</code> method must verify that <code>outputFile</code> is not null</li>
        <li>if <code>outputFile</code> is not empty, then it must be cleared before writing to it</li>
        <li>all files and directories of <code>root</code> must be processed</li>
        <li>non-license files must be ignored</li>
        <li>license files must be processed and info about it must be stored in <code>outputFile</code> (see formats in <code>Description</code> section)</li>
        <li>if license format is invalid, or any verification is failed, then <code>IllegalArgumentException</code> must be thrown</li>
        <li>all license properties are mandatory, except for <code>Expires on</code> (it's optional)</li>
        <li>the order of license properties are undefined</li>
        <li>the order in the resulting file does not matter</li>
        <li>if <code>Expires on</code> is omitted, then in <code>unlimited</code> must be used</li>
        <li><code>collectLicenses</code> does not throw any checked exception</li>
        <li><code>BufferedWriter/BufferedReader</code> must be used for IO operations</li>
        <li>All IO buffered streams must be defined using <code>try-with-resources</code> syntax</li>
    </ul>
</details>

### [Cipher Creator](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_21_introduction_to_i_o_streams/task_2_%D1%81ipher_%D1%81reator)
<details>
  <summary>Task</summary>
  <p>
    You will implement an input stream to process data from the file. Please also implement a util class to check a file and return a ciphered text.<br>
    Please implement methods in the CipherCreator.<br>
    <ul>
        <li><code>public static StringBuilder cipherText(File input)</code> - takes a file as an input and returns a ciphered text.</li>
    </ul>
    Please override methods in the TransformerInputStream class.<br>
    <ul>
        <li><code>public int read()</code> - reads the next data byte and returns a ciphered byte.</li>
        <li><code>public void close()</code> - closes the stream and prints a message about it to the console.</li>
    </ul>
    Cipher key points:<br>
    1. The text can only contain letters, and each word is written on a new line.<br>
    2. Each letter of the ciphered text is shifted by two characters from the original one, case-sensitive. A -> C, f ->h.<br>
    3. The alphabet is looped. It means Z -> B, y -> a.<br>
    4. All other characters are ignored.<br>
</details>

---

## Other I/O Streams

### [Cars](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_22_other_i_o_streams/task_1_cars)
<details>
  <summary>Task</summary>
  <p>
    <strong>Car Domain</strong><br>
    The Car class represents a car with some attributes:<br>
    <ul>
      <li>brand</li>
      <li>model</li>
      <li>cylinder capacity</li>
      <li>performance</li>
      <li>acceleration</li>
    </ul>
    <strong>Read CSV</strong><br>
    The first part of the exercise is to read cars from a CSV (comma-separated values) file. The CSV file contains the car attributes in the same order as listed above.<br>
    Implement the <code>CarCsvReader</code> class's <code>readCars(File file)</code> method to do the job.<br>
    <ul>
      <li>Read the file content line-by-line with <code>BufferedReader</code>. Then create a <code>Scanner</code> and configure it to use comma (,) as delimiter.</li>
    </ul>
    Input file example:<br>
    <code>Toyota,Corolla,1599,75,6.8</code><br>
    <code>Kia,Rio,1225,68,10.3</code><br>
    <strong>Formatted Printing</strong><br>
    Once the cars are in memory, print them to the console in the following way<br>
    <ul>
      <li>brand: 10 characters width</li>
      <li>model: 10 characters width</li>
      <li>cylinder capacity: 5 digits, add measurement unit: ccm</li>
      <li>performance: 3 digits, add measurement unit: kw</li>
      <li>acceleration: 5 digits, add measurement unit: sec</li>
    </ul>
    Implement the <code>FormattedCarPrinter</code> class's <code>print(List&ltCar&gt cars)</code> method.<br>
    Output example, given the above list of cars:<br>
    <code>    Toyota    Corolla  1599 ccm  75 kw  6.80 sec</code><br>
    <code>       Kia        Rio  1250 ccm  68 kw 10.30 sec</code><br>
</details>

---

## The Interface Approach to Working With Files via NIO.2

### [File Tree (NIO approach)](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_23_nio_2/task_1_file_tree)
<details>
  <summary>Task</summary>
  <p>
    You must implement a method to build a directory representation. You can also create other methods for convenience that will be called from the 'tree' method.<br>
    Please implement methods in the FileTree class.<br>
    <ul>
      <li><code>public Optional&ltString&gt tree(final Path path)</code> - takes a path to a file/directory as an input parameter and builds a String representation of its hierarchy.</li>
    </ul>
    1. If a given path <i>does not exist</i>, return an empty Optional.<br>
    2. If a given path <i>refers to a file</i>, return a String with its name and size like this:<br>
    <code>some-file.txt 128 bytes</code><br>
    3. If a given path <i>refers to a directory</i>, return a String with its name, total size and full hierarchy:<br>
    <code>some-dir 100 bytes</code><br>
    <code>├─ some-inner-dir 50 bytes</code><br>
    <code>│  ├─ some-file.txt 20 bytes    </code><br>
    <code>│  └─ some-other-file.txt 30 bytes</code><br>
    <code>└─ some-one-more-file.txt 50 bytes</code><br>
    <ul>
      <li>Use pseudo-graphic characters to format the output.</li>
      <li>Compute the size of a directory as a sum of all its contents.</li>
      <li>Sort the contents in the following way:</li>
        <ul>
            <li>Directories should go first.</li>
            <li>Directories and files are sorted in lexicographic order (case-insensitive)</li>
        </ul>
    </ul>
</details>

---

## Serialization

### [Serialization](https://github.com/denys-taranenko/learn-java-basic-epam/tree/main/LearnJavaBasics/src/main/java/com/epam/java/basics/module_24_serialization/task_1_serialization)
<details>
  <summary>Task</summary>
  <p>
    In this exercise, you need to implement the serialization of complex objects of the <code>Order</code> type. Below is a hierarchy of classes that describe orders.<br>
    <strong>Classes to be serialized</strong><br>
    The <code>Order</code> class represents an order:<br>
    <ul>
        <li><code>id</code></li>
        A unique identifier of the order<br>
        <li><code>total</code></li>
        The cost of the order, which is automatically calculated and can only be read<br>   
        <li><code>items</code></li>
        A map that stores products (a ke y is an object of the <code>Item</code> type) and the number of units to be purchased (a value is a variable of the <code>int</code> type)<br>
    </ul>
    The <code>Item</code> class represents a product:<br>
    <ul>
        <li><code>id</code></li>
        A unique identifier of the product<br>
        <li><code>name</code></li>
        The name of the product<br>   
        <li><code>description</code></li>
        A short description of the product<br>
        <li><code>characteristics</code></li>
        A list of product features (objects of the <code>ItemCharacteristic</code> type)<br>
    </ul>
    The abstract class <code>ItemCharacteristic</code> represents one characteristic of a product and is the supertype for different types of product characteristics:<br>
    <ul>
        <li><code>id</code></li>
        A unique identifier of the characteristic<br>
        <li><code>name</code></li>
        The name of the characteristic<br>   
        <li><code>type</code></li>
        A data type of the characteristic (It can be <code>String</code>, <code>Integer</code>, <code>Double</code>, etc.)<br>
    </ul>
    The <code>IntItemCharacteristic</code> class represents an integer characteristic and inherits the <code>ItemCharacteristic</code> class:<br>
    <ul>
        <li><code>value</code></li>
        Keeps a value of the characteristic<br>
    </ul> 
    The <code>DoubleItemCharacteristic</code> class represents a numeric characteristic and inherits the <code>ItemCharacteristic</code> class:<br>
    <ul>
        <li><code>value</code></li>
        Keeps a value of the characteristic<br>
    </ul>
    <strong>Class which performs serialization / deserialization</strong><br>
    The <code>OrderSerializer</code> class serializes and deserializes objects of the <code>Order</code> class:<br>
    <ul>
        <li><code>public static void serializeOrder(Order order, OutputStream out) throws IOException</code></li>
        Serializes a specified object of the Order class into the given data output stream<br>
        <li><code>public static Order deserializeOrder(InputStream in) throws IOException, ClassNotFoundException</code></li>
        Deserializes a specified object of the <code>Order</code> class from the given data input stream<br>
    </ul>    
    <strong>Details:</strong><br>
    <ul>
        <li>Each entity class must contain a constructor that accepts values for all fields and can contain any other constructors if necessary.</li>
        <li>All entity classes must have getters and setters for all fields.</li>
        <li>All entity classes must contain an overridden <code>equals()</code> method by all fields.</li>
        <li>The <code>ItemCharacteristic</code> class must be <code>abstract</code> and must not implement the <code>Serializable</code> interface.</li>
        <li>When calculating the cost of an order in the <code>Order</code> class, set the <code>total</code> field value using the following algorithm:</li>
        <ul>
            <li>If the <code>total</code> field is <code>null</code> and the <code>items</code> field is not <code>null</code>, then a call of the <code>getTotal()</code> method must calculate the <code>total</code> value.</li>
            <li>If the <code>items</code> field is <code>null</code>, the <code>total</code> must be zero.</li>
            <li>It is guaranteed that the internal state of the <code>items</code> field will not change after being installed in the object.</li>
        </ul>
        <li>The custom serialization mechanism must be implemented in all descendants of the <code>ItemCharacteristic</code> class because it is not serializable</li>
    </ul>
    <strong>Restrictions:</strong><br>
    <ul>
        <li>You may not use the serialization mechanism with the <code>Externalizable</code> interface.</li>
    </ul>
</details>