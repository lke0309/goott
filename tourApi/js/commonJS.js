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

function saveCookie(cookName, cookieValue, expires) {
  //넘겨받은 cookName이라는 이름으로,
  //넘겨받은 cookieValue 값을 쿠키에 저장하되,
  //만료일은 넘겨받은 현재날짜 +expires일로 저장하자.
  let now = new Date();
  now.setDate(now.getDate() + expires);
  let tmpCookie =
    cookName + "=" + cookieValue + ";expires=" + now.toUTCString();

  document.cookie = tmpCookie;
}

function getParameter(paramName) {
  // 쿼리스트링에서 넘겨받은 paramName을 찾아 그 변수의 값을 return 한다.
  // 만약 쿼리스트링에 paramName이 없다면  null을 return 한다.

  let returnVal = null;
  let url = location.href;

  if (url.indexOf("?") != -1) {
    // 쿼리스트링이 있을 때
    let queryStr = url.split("?")[1];
    console.log(queryStr);
    let tmpAr = queryStr.split("&");
    for (let tmp of tmpAr) {
      if (tmp.split("=")[0] == paramName) {
        returnVal = tmp.split("=")[1];
        break; //해당반복문 블럭 빠져나감.
      }
    }
  }
  return returnVal;
}
