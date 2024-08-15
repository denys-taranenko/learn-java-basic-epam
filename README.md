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