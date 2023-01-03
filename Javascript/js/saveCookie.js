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
