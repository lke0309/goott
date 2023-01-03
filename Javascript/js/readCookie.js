function readCookie(cookieName) {
  //쿠키이름을 매개변수로 받아
  //넘겨받은 쿠키 이름의 값을 반환하자.
  //만약 넘겨받은 쿠키의 이름에 해당하는 쿠키가 존재하지 않으면, null 을 반환
  let returnVal = null;

  let cookies = document.cookie;
  //   console.log(cookies);
  //   if (cookies == "") {
  //     console.log("쿠키없다.");
  //     return returnVal;
  //   }
  if (cookies != "") {
    //쿠키가 있다.
    let cookAr = cookies.split(";");
    console.log(cookAr);
    for (let cookie of cookAr) {
      console.log(cookie);
      console.log(cookie.split("="));
      if (cookie.split("=")[0].trim() == cookieName) {
        //넘겨받은 쿠키의 이름에 해당하는 쿠키가 있다.
        returnVal = cookie.split("=")[1]; //해당하는 쿠키의 값을 returnVal에 대입
        return returnVal;
      }
    }

    return returnVal; //찾는 쿠키 없다.
  }
}
