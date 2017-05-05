function loadDoc() {
  
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    parseDoc(this);
    }
  };
  xhttp.open("GET", "Sample.xml", true);
  xhttp.send();



}

function parseDoc(xml) {
  var i;
  var xmlDoc = xml.responseXML;
  var Project="<p>Part-Name</p>";
  var x = xmlDoc.getElementsByTagName("note");

  for (i = 0; i <x.length; i++) { 
    
    Project += "<p>Step:" +
    x[i].getElementsByTagName("step")[0].childNodes[0].nodeValue +
    "</p><p> Octave:" +
    x[i].getElementsByTagName("octave")[0].childNodes[0].nodeValue +
    "</p>";
  }
  
  document.getElementById("notes").innerHTML = Project;

}


var vf = new Vex.Flow.Factory({
  renderer: {selector: 'boo', width: 500, height: 200}
});
 
var score = vf.EasyScore();
var system = vf.System();
 
system.addStave({
  voices: [
    score.voice(score.notes('C#5/q, B4, A4, G#4', {stem: 'up'})),
    score.voice(score.notes('C#4/h, C#4', {stem: 'down'}))
  ]
}).addClef('treble').addTimeSignature('4/4');
 
vf.draw();