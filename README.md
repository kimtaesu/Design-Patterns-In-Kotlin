
[Command](/src/main/kotlin/taesu/Command.kt)
-----
![Command](/screen/Command.png)

```kotlin

Command 객체는 캡슐화 된 트랜잭션

활용 방안 : 스케쥴링, 로그 기록 시스템, undo / redo

Pros : 
 * Client는 Command 의 세부적인 구현체를 알지 못해도 상관없다.
 * 기존 코드를 변경하지 않고 새로운 명령을 추가 할 수 있기 때문에 확장성 측면에서 도움이 됩니다
 * undo / redo 기능으로 재사용이 가능합니다
Cons : 
 * 각 개별 명령에 대한 클래스 수가 증가한다.

```


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

