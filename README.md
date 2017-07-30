
[Command](/src/main/kotlin/taesu/Command.kt)
-----
![Command](/screen/Command.png)

Command 객체는 캡슐화 된 트랜잭션입니다. 



Office 문서 편집을 보시면 "undo / redo" 기능이 Command 패턴으로 개발된 것입니다.

또 Thread의 Runnable도 Command 의 일반적인 사레입니다.
 
그래서 저는 ThreadPool 예제로 작성해 보았습니다. 

Pros : 
 * 작업 단위를 객체화 함으로써 실제 수행하는 부분에서 분리가 가능합니다

[State](/src/main/kotlin/taesu/State.kt)
-----
![State](/screen/State.png)

Context 에 의하여 상태의 변경이 되며, 변경된 상태에 따라 행위가 바뀌게 됩니다.

Pros : 
 * Context 라는 한 곳에서 상태 관리가 되기 때문에 유지하기가 쉽습니다. 
 * Client 는 상태 전환에 신경 쓰지 않아도 됩니다. 
 
 [Visitor](/src/main/kotlin/taesu/Visitor.kt)
 -----
 ![Visitor](/screen/Visitor.png)
 
보통 한 클래스 내에 존재해야 할 데이터와 메소드를 다른 클래스로 분리하여 서로 간에 호출하도록 함으로써 향후 메소드 추가를 자유롭게 하려는 패턴입니다.


Cons : 
 * 대상 객체가 추가 될때마다 비지터에도 추가를 해줘야 한다.
 * 객체의 속성값을 직접 제어하므로 캡슐화가 약해진다. 

