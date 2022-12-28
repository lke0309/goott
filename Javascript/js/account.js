function Account(owner, accNum, balance) {
  //객체에 속성을 부여
  this.owner = owner; //this.owner는 멤버변수, owner는 지역변수
  this.accNum = accNum;
  this.balance = balance;
  this.bankName = "우리은행";
  this.name = "직장인 비과세 예금";

  //객체에 기능 부여
  this.inquiry = function () {
    //잔액조회
    return this.balance;
  };

  this.deposit = function (money) {
    //예금하기
    this.balance += money;
  };

  this.withDraw = function (money) {
    //인출
    if (this.balance >= money) {
      this.balance -= money;
    } else {
      window.alert("잔액부족");
    }
  };
}
