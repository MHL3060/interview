// Asana Homework Assignment
// Hungry Rabbit
// A very hungry rabbit is placed in the center of of a garden, represented by a rectangular N x M 2D matrix.
// 
// The values of the matrix will represent numbers of carrots available to the rabbit in each square of the garden. 
// If the garden does not have an exact center, the rabbit should start in the square closest to the center with the highest carrot count.
// 
// On a given turn, the rabbit will eat the carrots available on the square that it is on, 
// and then move up, down, left, or right, choosing the the square that has the most carrots. 
// If there are no carrots left on any of the adjacent squares, the rabbit will go to sleep. 
// You may assume that the rabbit will never have to choose between two squares with the same number of carrots.
// 
// Write a function which takes a garden matrix and returns the number of carrots the rabbit eats. 
// You may assume the matrix is rectangular with at least 1 row and 1 column, and that it is populated with non-negative integers. For example,
// 
// [[5, 7, 8, 6, 3],
//  [0, 0, 7, 0, 4],
//  [4, 6, 3, 4, 9],
//  [3, 1, 0, 5, 8]]
// 
// Should return
// 
// 27


/**
 * @author David W. Keith <dwkeith@gmail.com>
 *
 * I took this a step further and produced a graphical output of what is going
 * on. The work is broken up into four files:
 * 
 *  * garden_path.js
 *  * garden.js
 *  * rabbit.js
 *  * index.HTML
 *
 * Obviously for production, this would be run through some sort of compiler
 * to output the correct version of JavaScript (current ESLatest) and 
 * minify/combine the files.
 */

//***************************************************************************
// File garden_patch.js
//***************************************************************************

/**
 * A simple garden patch representation.
 * 
 * @class
 */
class GardenPatch {

    /**
     * A garden patch coordinate.
     * 
     * @constructor
     * @param {number} x - the x coordinate of the garden patch
     * @param {number} y - the y coordinate of the garden patch
     */
    constructor(x=0, y=0) {
      this.x = x;
      this.y = y;
    }
    
    /**
     * The nearest neigbhor to this garden patch in the specified direction.
     * 
     * Takes a Cardnial or Intercardinal direction as expressed in string
     * notation. See https://en.wikipedia.org/wiki/Cardinal_direction
     * 
     * @param {string} direction - a cardinal or intercardinal compass direction
     * @returns {GardenPatch}
     */
    getNearestNeighbor(direction) {
      const neighbor = new GardenPatch(this.x, this.y);
      // this could be more clever, but readability is key.
      switch(direction) {
        case 'north':
          neighbor.x--;
          break;
        case 'northeast':
          neighbor.x--;
          neighbor.y--;
          break;
        case 'northwest':
          neighbor.x--;
          neighbor.y++;
          break;
        case 'south':
          neighbor.x++;
          break;
        case 'southeast':
          neighbor.x++;
          neighbor.y--;
          break;
        case 'southwest':
          neighbor.x++;
          neighbor.y++;
          break;
        case 'east':
          neighbor.y--;
          break;
        case 'west':
          neighbor.x++;
          break;
      }
      return neighbor;
    }
  
  
    toString() {
      return `{${this.x}, ${this.y}}`;
    }
  }
  
  //***************************************************************************
  // File garden.js
  //***************************************************************************
  
  /**
   * A simple garden simulator which uses a matrixed array to represent
   * patches of carrots.
   * 
   * @class
   */
  class Garden {
    
    /**
     * Create a garden in the specified dementions and generate a random
     * number of carrots for each patch.
     *
     * HTML cordernates have {0,0} at the upper left and work down and to the
     * right from there.
     * 
     * @constructor
     * @param {number} length length of the new garden in patches
     * @param {number} width width of the new garden in patches
     * @param {number} maxCarrots maximum number of carrots per garden patch
     */
    constructor(length=20, width=20, maxCarrots=100) {
      this.plot = [];
      for (let i=0; i < length; i++) {
        this.plot.push(Array.from({length: width},
          () => Math.floor(Math.random() * maxCarrots)))
      }
    }
  
    /**
     * Returns the x,y cords of the center point in the garden. If there is no
     * center square in the garden, the square with the highest number of
     * carrots is returned. (out of the 4 possibilities.)
     *
     * @returns {GardenPatch}
     */
    getCenter() {
      
      // A simple isEven check to make this simpler to read.
      function isEven(num) {
        return num % 2 === 0;
      }
      
      const shouldCheckEastNeighbor = isEven(this.plot.length);
      const shouldCheckSouthNeighbor = isEven(this.plot[0].length);
  
      // `Math.round()` always rounds up when remainder is 0.5 (odd), which
      // gives us a perfect center on 0 indexed objects. Otherwise there are
      // 2 or 4 candidates near the center and we will pick the one with the
      // highest value.
      const center = new GardenPatch(
        Math.round(this.plot.length/2),
        Math.round(this.plot[0].length/2));
      const possibleCenters = [center];
  
      if (shouldCheckEastNeighbor || shouldCheckSouthNeighbor) {
        if (shouldCheckEastNeighbor) {
          possibleCenters.push(center.getNearestNeighbor('east'));
        }
        if (shouldCheckSouthNeighbor) {
          possibleCenters.push(center.getNearestNeighbor('south'));
        }
        if (shouldCheckSouthNeighbor && shouldCheckEastNeighbor) {
          possibleCenters.push(center.getNearestNeighbor('southeast'));
        }
      }
  
      // it is easier to sort 4 items of the same value than figure out if
      // we have multiple items of the same value. If the number of items were
      // greater, we would use a smarter algorithm here.
      return possibleCenters.sort(
        this.compareCarrotsAtPositions.bind(this))[0];
    }
  
    /**
     * For a given set of cordinates, returns the neighbor with the
     * highest number of carrots. We are only checking cardinal directions.
     *
     * To support diagnal directions, uncomment the intercardinal lines.
     *
     * @param {GardenPatch} gardenPatch: x,y cords
     * @returns {GardenPatch} x,y cords
     */
    getMostProductiveNeighbor(gardenPatch) {
      // using `Array.prototype.sort()` as we only have 8 values
      // if the number of items were significantly higher, we would look for
      // the largest value rather than sort.
      return [
        gardenPatch.getNearestNeighbor('north'),
        // gardenPatch.getNearestNeighbor('northeast'),
        // gardenPatch.getNearestNeighbor('northwest'),
        gardenPatch.getNearestNeighbor('south'),
        // gardenPatch.getNearestNeighbor('southeast'),
        // gardenPatch.getNearestNeighbor('southwest'),
        gardenPatch.getNearestNeighbor('east'),
        gardenPatch.getNearestNeighbor('west')].sort(
          this.compareCarrotsAtPositions.bind(this))[0];
    }
  
    /**
     * For a set of GardenPatchs returns an integer indicating which patch
     * has more carrots or 0 if they have the same number of carrots.
     * 
     * e.g.:
     *   -1: patch a has more carrots
     *    1: patch b has more carrots
     *    0: patch a and b have the same number of carrots
     *
     * Suitable for passing to `Array.prototype.sort()` when bound to an
     * instance of the Garden class.
     *
     * @param {GardenPatch} a: A GardenPatch position object
     * @param {GardenPatch} b: A GardenPatch position object
     * @returns {number} a comparitor number 
     */
    compareCarrotsAtPositions(a, b) {
      const carrotsAtA = this.numberOfCarrotsAt(a);
      const carrotsAtB = this.numberOfCarrotsAt(b);
      if (carrotsAtA > carrotsAtB) {
        return -1;
      } else if (carrotsAtA < carrotsAtB) {
        return 1;
      }
      return 0;
    }
    
    /**
     * Picks carrots at a given point and returns the number of carrots
     *
     * @param {GardenPatch} gardenPatch: x,y cords
     * @returns {number} of carrots picked
     */
    pickCarrots(gardenPatch) {
      const numberOfCarrotsPicked = this.numberOfCarrotsAt(gardenPatch);
      this.plot[gardenPatch.y][gardenPatch.x] = 0;
      return numberOfCarrotsPicked;
    }
  
    /**
     * Returns true if the passed GardenPatch is located inside this garden.
     *
     * @param {GardenPatch} gardenPatch: GardenPatch object
     * @returns {boolean}
     */
    isPatchInsideGarden(gardenPatch) {
      const isInvalidXCoordinate = gardenPatch.x < 0 ||
                                   gardenPatch.x >= this.plot.length;
      const isInvalidYCoordinate = gardenPatch.y < 0 ||
                                   gardenPatch.y >= this.plot[0].length;
      return isInvalidXCoordinate || isInvalidYCoordinate;
    }
  
    /**
     * Returns the number of carrots at a given position.
     * If the position is invalid, returns zero, as carrots
     * don't grow outside the garden.
     *
     * @param {GardenPatch} gardenPatch: GardenPatch object
     * @returns {number} carrots in the specified GardenPatch
     */
    numberOfCarrotsAt(gardenPatch) {
      return this.isPatchInsideGarden(gardenPatch) ? 
             0 : this.plot[gardenPatch.y][gardenPatch.x];
    }
    
    /**
     * Returns an HTML Table repersentation of the garden.
     *
     * This is not the most efficent way to generate HTML, but it works
     * for this simple demo.
     *
     * @returns {string} HTML Table version of the garden
     */
    toHTML() {
      let html='<table><tbody><tr><th></th>';
      for (let columnID = 0, plotLength = this.plot.length;
           columnID < plotLength;
           columnID++) {
        html += `<th>${columnID}</th>`
      }
      html += `</tr>`;
      this.plot.forEach((gardenRow, rowID) => {
        html += `<tr><th>${rowID}</th>`;
        gardenRow.forEach((carrots, columnID) => {
          const CSSclass = carrots === 0 ? 'empty' : 'carrots';
          html += `<td class="${CSSclass}" id="plot${rowID}:${columnID}">
                  ${carrots}🥕</td>`;
        })
        html += '</tr>';
      })
      return html + '</tbody></table>';
    }
  }
  
  // File rabbit.js
  
  /**
   * A simple hungry rabbit simulator.
   * 
   * @class
   */
  class Rabbit {
    
    /**
     * Create a rabbit instance and place it in the center of the garden.
     *
     * @constructor
     * @param {Garden} garden garden in which the rabbit will eat
     */
    constructor(garden) {
      this.garden = garden;
      this.position = this.garden.getCenter();
      this.carrotsEatten = 0;
    }
  
    /**
     * Have the rabbit eat the carrots as the current position in  the garden.
     * 
     * @returns {number} carrots eaten
     */
    eatCarrots() {
      const numCarrots = this.garden.pickCarrots(this.position);
      this.carrotsEatten = this.carrotsEatten + numCarrots;
      return numCarrots;
    }
  
    /**
     * Have the rabbit move to the neigboring patch in the garden with the
     * most carrots. Returns false if all neighboring patches have zero carrots.
     * 
     * @returns {boolean} true if the rabbit was able to find another patch
     */
    moveToMostProductiveNeigbhor() {
      const newPosition = this.garden.getMostProductiveNeighbor(this.position);
      // only move if there is somewhere to move to.
      if (this.garden.numberOfCarrotsAt(newPosition) !== 0) {
        this.position = newPosition;
        return true
      }
      return false;
    }
    
    /**
     * Returns an HTML complient ID string that matches the rabbit's position
     * in the garden.
     * 
     * @returns {string} HTML ID for this position
     */
    positionID() {
      return `plot${this.position.y}:${this.position.x}`
    }
  }
  
  //***************************************************************************
  // File index.html (script tag)
  //***************************************************************************
  
  // A sample of the HTML would be:
  
  // <!doctype html>
  // <html lang="en">
  //     <head>
  //         <meta charset="utf-8">
  //         <title>Hungry Rabbit</title>
  //         <meta name="description" content="">
  //         <meta name="viewport" content="width=device-width, initial-scale=1">
  //     </head>
  //     <style>
  //       td {
  //         background-color: DarkGreen;
  //         text-shadow: 1px 1px 1px white;
  //         text-align: center;
  //         padding: 0.25em;
  //       }
  //       tr:nth-child(even) td:nth-child(odd), 
  //       tr:nth-child(odd) td:nth-child(even) {
  //           background-color: Green;
  //       }
  //       td.eatten {
  //         background-color: Brown;
  //       }
  //       tr:nth-child(even) td.eatten:nth-child(odd),
  //       tr:nth-child(odd) td.eatten:nth-child(even) {
  //           background-color: SaddleBrown;
  //       }
  //       td.eatten {
  //         color: Orange;
  //       }
  //     </style>
  //     <body>
  //       <h1>Hungry Rabbit</h1>
  //       <h2>Mr. McGregor's Garden<br>Press space bar to speed up the rabbit.</h2>
  //       <div id="garden"></div>
  //       <div id="total"></div>
  //       <script src="garden_patch.js"></script>
  //       <script src="garden.js"></script>
  //       <script src="rabbit.js"></script>
  //       <script>
  //          // Insert script here.
  //       </script>
  //     </body>
  // </html>
  
  
  
  /*
   * The most famous hungry rabbit is Peter Rabbit, of Beatrix Potter's
   * 1902 story, "The Tale of Peter Rabbit". Thus our instances pay homage
   * to that famous character.
   */
  
  // we could prompt the user here for the size of the garden, for now defaults.
  const MrMcGregorsGarden = new Garden();
  const Peter = new Rabbit(MrMcGregorsGarden);
  let moreCarrots = true;
  let waitTime = 500;
  
  /**
   * Similar to Steve Job's infamous option-key animation demos, this
   * demo runs at a speed humans can see. This simple event listener
   * allows us to speed up the rabbit for quicker evaluation.
   *
   */
  function onKeyDown(event) {
    // Space Bar is keyCode 32
    if(event.keyCode === 32) {
      waitTime = waitTime === 500 ? 0 : 500;
    }
  }
  
  /**
   * The main loop, eats the carrots, if there are no more carrots to eats,
   * ends the loop.
    *
   */
  function eatCarrots() {
    carrotsEatten = Peter.eatCarrots();
    let plotEatten = document.getElementById(Peter.positionID());
    plotEatten.className = 'eatten';
    plotEatten.innerText = plotEatten.innerText.replace('🥕','🐇');
    moreCarrots = Peter.moveToMostProductiveNeigbhor();
    if (moreCarrots) {
      setTimeout(eatCarrots, waitTime);
    } else {
      document.getElementById('total').innerText =
        `Peter Rabbit ate a total of ${Peter.carrotsEatten.toLocaleString()} carrots from Mr. McGregor's garden and has gone to sleep at garden patch ${Peter.position}.`;
    }
  }
  
  // Go!
  document.getElementById('garden').innerHTML = MrMcGregorsGarden.toHTML();
  document.addEventListener('keydown', onKeyDown);
  eatCarrots();
  