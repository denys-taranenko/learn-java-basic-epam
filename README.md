# Java Programming Tasks

This document contains descriptions of various problems for practicing Java programming. Each problem is accompanied by a link to the corresponding class in which it can be solved and detailed instructions.

---

## First Programs in Java

### Meet Autocode
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>HelloAutocode</code> class and write a simple program that prints <i>"Hello, Autocode!"</i> (don't print quote marks).
  </p>
</details>

### Meet a Stranger
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to the class <code>MeetAStranger</code>. The program must read a string from <code>System.in</code> and print a message <i>"Hello, input"</i>. Note that when entering an input string consisting of several words, the entire input must be printed.
  </p>
</details>

---

## Data Types

### Electronic Watch
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

### Meet an Agent
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

### Meet Strangers
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

### Snail
<details>
  <summary>Task</summary>
  <p>
    Consider a snail travels up a tree <code>a</code> feet each day. Then snail slides down <code>b</code> feet each night. Height of the tree is <code>h</code>.<br>
    Please, proceed to <code>Snail</code> class and write a program that prints number of days for the snail to reach the top of the tree.<br>
    Program reads <code>a</code>, <code>b</code>, <code>h</code> line by line. Input values are guaranteed to be positive integers.<br>
    If the snail cannot reach the top of the tree, print the message <i>"Impossible"</i>.
  </p>
</details>

### Go Dutch
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

### Max Value In Sequence
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

### Average
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

### Pizza Split
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

### Quadratic Equation
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

### Max method
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

### Sum of even numbers
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

### Sum of previous
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

### Local maxima remove
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

### Cycle Swap
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

### Spiral
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

### Matrix Transposition
<details>
  <summary>Task</summary>
  <p>
    Please, proceed to <code>TransposeMatrix</code> class an implement its method <code>multiply</code>.<br>
    It takes a rectangular integer array (matrix) as a parameter and returns it transposed.<br>
    Consider an integer matrix represented as a <strong>rectangular array</strong>. The task is to <strong>transpose</strong> a given matrix over its main diagonal. The <strong>transposition</strong> of a matrix over its main diagonal is simply a flipped version of the original matrix.
</details>

### Matrices Multiplication
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

### Line Intersection
<details>
  <summary>Task</summary>
  <p>
    Please, implement the method <code>intersection(Line)</code> in class <code>Line</code>. It must return a <code>Point</code> of intersection of two lines.<br>
    Note that lines are defined by linear equations: <code>y = k * x + b</code>. Line constructor takes <code>k</code> and <code>b</code> coefficients as parameters.<br>
    If lines coincide or do not intersect, the method must return null. It may seem surprising that we use <code>int</code> for arguments and fields of coordinates. The point is that using <code>double</code> will bring some extra complexity we want to avoid for this basic exercise. All tests are selected in to induce calculations without remainders.<br>
    You may check your result in class <code>Main</code>.
</details>

### Segments
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

### Triangle
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

### Decrementing Carousel
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

### Halving Carousel
<details>
  <summary>Task</summary>
  <p>
    Note, that if you have not done the "Decrementing Carousel" exercise, you have to implement <code>DecrementingCarousel</code> and <code>CarouselRun</code> classes.<br>
    In this exercise you need to extend <code>DecrementingCarousel</code>. You need to implement <code>HalvingCarousel</code>. This subclass must halve elements instead of decrementing it by one. Note that you need to apply regular integer division, discarding the remainder. For example, <code>5 / 2 = 2</code>.
</details>

### Gradually Decreasing Carousel
<details>
  <summary>Task</summary>
  <p>
    Note, that if you have not done the "Decrementing Carousel" exercise, you have to implement <code>DecrementingCarousel</code> and <code>CarouselRun</code> classes.<br>
    In this exercise you need to extend <code>DecrementingCarousel</code>. You need to implement <code>GraduallyDecreasingCarousel</code>. This subclass must decrement elements by gradually increasing decrement. When you need to decrement an element for the first time, decrease it by <code>1</code>. Next time you need to decrement the same element, decrease it by <code>2</code>. Next time decrease by <code>3</code>, then by <code>4</code> and so on. Remember that you must not make process non-positive elements.
</details>

### Decrementing Carousel with Limit
<details>
  <summary>Task</summary>
  <p>
    Note, that if you have not done the "Decrementing Carousel" exercise, you have to implement <code>DecrementingCarousel</code> and <code>CarouselRun</code> classes.<br>
    In this exercise you need to extend <code>DecrementingCarousel</code>. You need to implement <code>DecrementingCarouselWithLimitedRun</code>. This subclass must decrement elements as a usual DecrementingCarousel. The difference is that this implementation must produce a carousel run, which limits number of calls to the <code>next</code> method. When the limit of calls reached carousel run must consider itself finished.
</details>

### SprintPlanning
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
            <li><code>getDependencies()</code> - Returns a defensive copy of dependencies array.</li>
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