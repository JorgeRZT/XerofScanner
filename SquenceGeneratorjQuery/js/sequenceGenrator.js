function creatSequence(size){
  var sequence = "";
  for(var i = 0 ; i < size; i++){
    sequence += getRandomChar();
  }
  return sequence;
}

function getRandomChar(){
  var chars = ["A","T","C","G"];
  return chars[Math.floor((Math.random() * chars.length))];
}
