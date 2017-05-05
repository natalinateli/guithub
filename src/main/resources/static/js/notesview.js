VF = Vex.Flow;

// Create an SVG renderer and attach it to the DIV element named "boo".
var div = document.getElementById("boo-main")
console.log(div);
var renderer = new VF.Renderer(div, VF.Renderer.Backends.SVG);

// Configure the rendering context.
renderer.resize(500, 500);
var context = renderer.getContext();
context.setFont("Arial", 10, "").setBackgroundFillStyle("#eed");

// Create a stave of width 400 at position 10, 40 on the canvas.
var stave = new VF.Stave(100, 40, 400);

// Add a clef and time signature.
stave.addClef("treble").addTimeSignature("4/4");

// Connect it to the rendering context and draw!
stave.setContext(context).draw();

var notes = [
  new VF.StaveNote({clef: "treble", keys: ["e##/5"], duration: "8d" }).
	  addAccidental(0, new VF.Accidental("##")).addDotToAll(),
  new VF.StaveNote({clef: "treble", keys: ["b/4"], duration: "8d" }).
  	addAccidental(0, new VF.Accidental("b")),
  new VF.StaveNote({clef: "treble", keys: ["c/4"], duration: "8" }),
  new VF.StaveNote({clef: "treble", keys: ["d/4"], duration: "16" }),
  new VF.StaveNote({clef: "treble", keys: ["e/4"], duration: "16" }).
	  addAccidental(0, new VF.Accidental("b")),
  new VF.StaveNote({clef: "treble", keys: ["d/4"], duration: "16" }),
  new VF.StaveNote({clef: "treble", keys: ["e/4"], duration: "16" }).
  	addAccidental(0, new VF.Accidental("#")),
  new VF.StaveNote({clef: "treble", keys: ["g/4"], duration: "32" }),
  new VF.StaveNote({clef: "treble", keys: ["a/4"], duration: "32" }),
  new VF.StaveNote({clef: "treble", keys: ["g/4"], duration: "16" }),
  new VF.StaveNote({clef: "treble", keys: ["d/4"], duration: "q" })
];

var beams = VF.Beam.generateBeams(notes);
Vex.Flow.Formatter.FormatAndDraw(context, stave, notes);
beams.forEach(function(b) {b.setContext(context).draw()})


// Create an SVG renderer and attach it to the DIV element named "boo".
var div = document.getElementById("boo-reg")
console.log(div);
var renderer = new VF.Renderer(div, VF.Renderer.Backends.SVG);

// Configure the rendering context.
renderer.resize(500, 500);
var context = renderer.getContext();
context.setFont("Arial", 10, "").setBackgroundFillStyle("#eed");

// Create a stave of width 400 at position 10, 40 on the canvas.
var stave = new VF.Stave(100, 40, 400);

// Add a clef and time signature.
stave.addClef("treble").addTimeSignature("4/4");

// Connect it to the rendering context and draw!
stave.setContext(context).draw();

var notes = [
  new VF.StaveNote({clef: "treble", keys: ["e##/5"], duration: "8d" }).
    addAccidental(0, new VF.Accidental("##")).addDotToAll(),
  new VF.StaveNote({clef: "treble", keys: ["b/4"], duration: "8d" }).
    addAccidental(0, new VF.Accidental("b")),
  new VF.StaveNote({clef: "treble", keys: ["c/4"], duration: "8" }),
  new VF.StaveNote({clef: "treble", keys: ["d/4"], duration: "16" }),
  new VF.StaveNote({clef: "treble", keys: ["e/4"], duration: "16" }).
    addAccidental(0, new VF.Accidental("b")),
  new VF.StaveNote({clef: "treble", keys: ["d/4"], duration: "16" }),
  new VF.StaveNote({clef: "treble", keys: ["e/4"], duration: "16" }).
    addAccidental(0, new VF.Accidental("#")),
  new VF.StaveNote({clef: "treble", keys: ["g/4"], duration: "32" }),
  new VF.StaveNote({clef: "treble", keys: ["a/4"], duration: "32" }),
  new VF.StaveNote({clef: "treble", keys: ["g/4"], duration: "16" }),
  new VF.StaveNote({clef: "treble", keys: ["d/4"], duration: "q" })
];

var beams = VF.Beam.generateBeams(notes);
Vex.Flow.Formatter.FormatAndDraw(context, stave, notes);
beams.forEach(function(b) {b.setContext(context).draw()})