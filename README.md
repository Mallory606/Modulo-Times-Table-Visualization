CS 351 Project 1

Modulo Times Table Visualization

Ashley Krattiger

Main is in ModuloTimesTableVisualization.java.
This program takes no arguments.
Upon initializing this program opens the window
and has a blank space where the visualization
should be. Pressing the "Start" button will begin
the visualization. Using the interface on the 
right side of the window, you can customize your 
visualization based on the number of dots, times
table, framerate, interval by which the
times table changes, and the color of the 
visualization. By using the "Jump to Frame" 
button, you automatically pause the simulation 
and generate the frame described in the settings
interface. If you press start while paused on a
specific frame, it will begin the simulation
from the frame you are currently on and with
the up-to-date specifications from the interface.
Pressing the "Restart" button will instantly begin
a new visualization with the specifications from
the interface at any point when it's pressed.
Color can be changed at any time, even when the
visualization is not actively updating. By
pressing the "Favorites" button, you will
automatically load a still frame from a hard-coded
list of 10 frames I liked. Pressing the button
again will load the next frame in the list, and
once you're through it'll start from the beginning
of the list again. Program exits upon exiting the
window.

Visualizations can handle numbers of dots from 1
to 360 in whole numbers and times tables from 1 
to 360 in double values. For numbers of dots, the
program automatically rounds up to an even number.
So, there are no visualizations with an odd number
of dots present. 

I left a bit of debugging code in Display.java. 
It is currently commented out. When implemented,
it will draw the dots on the visualization in
black so you can check their positions.