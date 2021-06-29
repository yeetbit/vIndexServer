var LogicController = (function(){
 
    var tree = [[]],newTree, treeTemplate, nodeCount = 0, branchCount = 0, rowcount = 0;

    // future upgrades: scanning through array for latest or highest ID

    function idRange(oldTree){                  // function returns next branchID/branchNumber
        let x,y,z;
            x = oldTree.length-1,               // check range of branches
            y = oldTree[x].length,            // check range of Nodes 
            z = oldTree[x][y-1][2];               // retrieve last Node ID

        if(z === x){        // if last branchCount of existing object equals number of rows, then branchID++
            return{
                branchID: x+1,
                retour: `1st condition: x${x},y${y},z${z}`
            };
        }else if(z < x){    // if last branchCount of existing object is smaller then actual number of rows, then branchID++      
            return{
                branchID: x+1,
                retour: `2nd condition: x${x},y${y},z${z}`
            };
        }else if(z > x){    // if last branchCount of existing object is greater then number of branches, use existing ID++
            return{
                branchID: z+1,
                retour: `3rd condition: x${x},y${y},z${z}`
            };
        }else{console.log(
            `
            no conditions are met @ sID function: 
            x value: ${x}
            y value: ${y}
            z value: ${z}
            ${oldTree}
            `)};
    }

    return {
        itemDataConstruct: function(newValues, existingData){                                                 // METHOD: construct Item Location

            if (rowcount != 0){                                                         // check if table/Toprow exists
                
                let sID = idRange(existingData), branchID = sID.branchID;   // fetch highest ID
                var branch = [];
                var alteredBaseConstruct = existingData[0]

                console.log(alteredBaseConstruct)
                


                alteredBaseConstruct.forEach(function(node){
                    node[0] = newValues[nodeCount];    // add new value to 1st node index
                    node[3] = branchID;                // add current branchID to 4th node index
                    node[4] = nodeCount;               // add current nodeID to 5th node index
                    branch[nodeCount] = node           // create node in branch index                                        
                    nodeCount++
                });

                newTree[branchCount] = branch;          // add new branch to tree index

            }else if(rowcount === 0){                   // if there no branches exist build mainbranch

                treeTemplate = newValues;

                treeTemplate.forEach(function(node){
                    tree[branchCount][nodeCount] = node;
                    nodeCount++;
                });

                newTree = tree;
                console.log(newTree)

            }else{console.log(`construction error,\n branchCount = ${branchCount},\n counter i = ${nodeCount},\n ${newValues[nodeCount]}`)}
            nodeCount = 0;                              // reset nodecounter
            branchCount++;                              // UP branchcounter value 
            rowcount++;                                 // UP logiccounter value 
            return newTree;
        },
        checkRegEx: function (dob, amnt, perC){                             // Method: check regular expression, via while loop iterating over array and returning boolean condition array 
            let i = 0, R = 0;
            let inputData = [dob, amnt, perC];                              //  array base
            const regdate = /((\d\d)\-(\d\d)\-(\d\d\d\d))/;                 //  regular expression for date
            const regnum = /((\D))/;                                        //  regular expression for am NON-Digit 
            while(i < inputData.length){                                    //  while i is smaller then array length
                condition[i] = (regdate.exec(inputData[i])) ? true :        //  test condition of current arrayvalue
                    (regnum.exec(inputData[i]))? false : true;
                console.log(`checkReg: condition ${i} = ${condition[i]}`);
                i++;
            } 
            i = 0;
            while(i < condition.length){
                if(condition[i] === false){
                    if(condition[i] === condition[0]){
                        console.log(`reportState: ${inputData[i]} returned false`);
                        condition[i] = `Date format must be dd-mm-yyyy`;
                    }else if(condition[i] === condition[1]){
                        console.log(`reportState: ${inputData[i]} returned false`);
                        condition[i] = `\n \n Ammount can only be numbers`;
                    }else if(condition[i] === condition[2]){
                        console.log(`reportState: ${inputData[i]} returned false`);
                        condition[i] = `\n \n Interest can only be numbers`;
                    }else{console.log("reportState: no conditions are met tier 1")};
                }else if (condition[i] === true){
                    R ++;                                                   // if condition is true, R++, if all attributes are true R value equals i value
                }else{console.log("reportState: no conditions are met tier 2")};
                i++;
                console.log(`R=${R}, i=${i}`)                               // end of while
            }if(R === (condition.length)){                                  // if R value equals length of array, conditions return true > Ctrlagent.CtrlIO.uiIOdata
                conditions = true;
            }else{
                console.log("reportState: not all conditions are met tier 3");
                conditions = false;
            }
            return conditions;
        },
        retrieveFalseValues: function(){                                    // Method: return falsy condition array
            return condition;
        }
    }
})();

var UIController = (function() {   

    var newItemBtns = ["add", "clear", "close", "random fill"],
        landingViewBtns = ["new Item", "show Table", "show Tiles", "options"],
        inputCollection = [], 
        buttonCollection = [
            [], // positon 0 = reserved for mainMenuBtn
            []  // positon 1 = reserved for addItemAttribList 
        ];




                    
    return {
        tableConfig: function(){
            config = [
            
                /* Constructor attributes: 
                    0 = Top row string, 
                    1 = Default input string, 
                    2 = table id,
                    3 = row id,
                    4 = coll id, 
                    5 = Options list array
                */
    
                [ "Country", "Country of origin", 0, 0, 0, ["geo-location", "options"]],
                [ "Region", "Region", 0, 0, 0, ["geo-location", "options"]],
                [ "Producer", "Producer", 0, 0, 0, ["Website", "Telephone number", "geo-location"]],
                [ "Prod date", "Production Date", 0, 0, 0, ["drink before", "reminder"]],
                [ "Grape", "grape type", 0, 0, 0, ["Wiki-link", "Wiki-grape-types"]],
                [ "Color", "color of wine", 0, 0, 0, ["options", "options"]],
                [ "Taste", "wine taste", 0, 0, 0, ["Goes with", "Comment"]],
                [ "Price", "price per bottle", 0, 0, 0, ["currentmarketvalue fetch", "purchase price"]],
                [ "Stock", "bottles in stock", 0, 0, 0, ["qty per box", "where to buy"]],
                [ "Comment", "Comments", 0, 0, 0, ["options", "options"]],
                [ "pictures", "Pictures", 0, 0, 0, ["front", "rear","other"]]
            ];

            return config;
        },
        mainMenuBtn: function(){                                                            // create HTML tags voor main menu buttons
            
            let i = 0, btn, bID;
            while(i < landingViewBtns.length){ 
                btn = document.createElement("INPUT");
                bID = `${landingViewBtns[i]}`;
                Object.assign(btn, {                                                            // add button attributes
                    type: "button",
                    className: 'landingViewBtns',
                    id: bID,
                    defaultValue: landingViewBtns[i],
                });
            document.getElementById('topbuttoncontainer').appendChild(btn);
            buttonCollection[0][i] = bID

                i++;
            }return{
                ID: buttonCollection,
                bStr: landingViewBtns 
            };

        },
        displayPort: function(){

        },
        tableConstructor: function(table){                                      // METHOD: TABLE CONSTRUCTION


            var nodeCount = 0, rowCount = 0, delKey = [];

            console.log(table)
        
        
        
        
            table.forEach(function(branch){
                if(rowCount === 0){
                    buildToprow(branch[rowCount]);           
                    buildNodesTopRow(branch);
                }else if(rowCount != 0){
                    buildSubRow(branch[rowCount]);
                    buildNodesSubRow(branch);
                }else{console.log('table foreach function kaput')};
            })

            function buildToprow(toprow){
                let rowID = toprow[3],
                    colID = toprow[4],
                    t = document.createElement("TABLE"),
                    r = document.createElement("TR"),
                    numC = document.createElement("TD"),
                    rowNum = document.createTextNode("Item#");

                //create HTML table tags
                t.setAttribute("id", `table`);
                document.getElementById("tablecontainer").appendChild(t);
        
                //create HTML row tags
                Object.assign(r, {
                    className: `row-${rowID}`,
                    id: `row-${rowID}`,
                });
                document.getElementById(`table`).appendChild(r);
        
                //create row number
                numC.appendChild(rowNum);
                Object.assign(numC, {
                    className: `row-${rowID}`,
                    id: `numbercel-${rowID}-${colID}`,
                });
                document.getElementById(`row-${rowID}`).appendChild(numC);
            }

            function buildNodesTopRow(toprow){                


                // fill row with textnodes
                toprow.forEach(function(node){
                    console.log(node)
                    let rowID = node[3],
                        colID = node[4];
                        cellID = `cell-${rowID}-${colID}`,                               // collect cell-ID
                        td = document.createElement("TD"),
                        c = document.createTextNode(node[0]);

                    td.appendChild(c);
        
                    Object.assign(td, {
                        className: `row-${rowID}`,
                        id: cellID,
                    });
                    document.getElementById(`row-${rowID}`).appendChild(td);
                    
                    nodeCount++
        
                    if( nodeCount === toprow.length ){
                        let TD = document.createElement("TD");                                  // assign Delete collumn to end of table row
                        let B = document.createTextNode("delete");
        
                        TD.appendChild(B);
                        Object.assign(TD, {
                            className: `row-${rowID}`,
                            id: `deletecel-${rowID}-${colID}`,
                        });
                        document.getElementById(`row-${rowID}`).appendChild(TD);
                    }
                })
                return rowCount++
            }
            function buildSubRow(subrow){
                let rowID = subrow[rowCount][nodeCount][3],
                    colID = subrow[rowCount][nodeCount][4],
                    r = document.createElement("TR"),
                    numC = document.createElement("TD"),
                    rowNum = document.createTextNode(`${rowCount}`);
    
    
        
                //create HTML row tag
                Object.assign(r, {
                    className: `row-${rowID}`,
                    id: `row-${rowID}`,
                });
                document.getElementById(`table`).appendChild(r);
        
                //create row number
                numC.appendChild(rowNum);
        
        
                Object.assign(numC, {
                    className: `row-${rowID}`,
                    id: `numbercel-${rowID}-${colID}`,
                });
                document.getElementById(`row-${rowID}`).appendChild(numC);
                
            }
            function buildNodesSubRow(subrow){
                subrow.forEach(function(node){
                    let cellID = `cell-${rowID}-${colID}`,                               // collect cell-ID
                        td = document.createElement("TD"),
                        c = document.createTextNode(node[rowCount][nodeCount][0]);
                    td.appendChild(c);
        
                    Object.assign(td, {
                        className: `row-${rowID}`,
                        id: cellID,
                    });
                    document.getElementById(`row-${rowID}`).appendChild(td);
        
                    nodeCount++
                    
                    // create delete button, and return row & arrays specs
                    if( nodeCount === subrow.length ){
                        let TD = document.createElement("TD");                                  // assign Delete collumn to end of table row
                        let B = document.createTextNode("delete");
        
                        TD.appendChild(B);
                        Object.assign(TD, {
                            className: `row-${rowID}`,
                            id: `deletecel-${rowID}-${colID}`,
                        });
                        document.getElementById(`row-${rowID}`).appendChild(TD);
                        delKey[rowCount] = [`row-${rowID}`, rowCount, nodeCount];
                    }
                })
                return rowCount++
            }
            return delKey;
        },
        addItemAttribList: function(tableAttrib){                                                  // METHOD: BUILD INPUT LIST

            let i=0, X=0, inID, br, inp;

            while(i < tableAttrib.length){                                                      // iterate over input-field elements

            inp = document.createElement("INPUT");                                              // create HTML input tag
            br = document.createElement("BR");
            inID = `inputfield-${i}`;                                       // collect input elementID

            br.setAttribute("class", 'inputform');
            Object.assign(inp, {                                                                // Add attributes to Input element
                type: 'text',
                className: 'inputform',
                id: inID,
                defaultValue: tableAttrib[i][1],
            });

            inputCollection[i] = inID;                                                          // store input Element-ID's in sequence 
            
            document.getElementById("inputcontainer").appendChild(inp);                         // write to document
            document.getElementById("inputcontainer").appendChild(br);                  
            i++
            };

            while(X < newItemBtns.length){                                                      // iterate over button elements
                let btn = document.createElement("INPUT");
                let bID = `btn-${i}`;
                Object.assign(btn, {                                                            // add button attributes
                    type: "button",
                    className: 'inputform',
                    id: bID,
                    defaultValue: newItemBtns[X],
                });

                buttonCollection[1][X] = bID;                                                   // store button Element-ID's in sequence
                document.getElementById('buttoncontainer').appendChild(btn);
                X++;
                i++; 
            };
            return {                                                                            // return collection of Element-ID's
                inputElements: inputCollection,
                btnElements: buttonCollection,
                tableAtrib: tableAttrib, 
                btnStrings: newItemBtns               
            }
        },
        readInputList: function(){                                                      // METHOD: ITERATE OVER INPUT & RETURN ARRAY

            let i = 0,
                input = [];

            while(i < inputCollection.length){
                input[i] = document.getElementById(inputCollection[i]).value;
                i++;
            }return input;
        },
        setInputDefault: function(){
            let i = 0
            while(i < inputCollection.length){
                document.getElementById(inputCollection[i]).value = tableAttrib[i][1];
                i++;
            }

        },
        removeElementsByClass: function(className){
            var elements = document.getElementsByClassName(className);
            while(elements.length > 0){
                elements[0].parentNode.removeChild(elements[0]);
            }
        },
        newItem: function(){
            let btn = document.createElement("INPUT");
            let bID = `newitem`;
                Object.assign(btn, {                                                            // add button attributes
                    type: "button",
                    className: 'additembutton',
                    id: bID,
                    defaultValue: 'New entry',
                });
            document.getElementById('buttoncontainer').appendChild(btn);
        }
    };
})();

var CtrlAgent = (function(logicCtrl, UICtrl){           // Main control module
    var DOM, data, output, falseData, eventFunctions = [[],[],[],[],[]], additemELID, dataCollection, tableAttrib;

    /* steps:
        log-in,
        generate buttons: show wine table, logout,
            get elements by id
            add event listeners
        
        pressed show wine table,
            build table,
            generate buttons: new item
                get elements by id
                add event listeners

            generate add item list

    */

    function landingView() {

        // generate button ui
        let btn = UICtrl.mainMenuBtn();
        mainMenuEAL(btn.ID, btn.bStr);
        initializeTableConfig()
        // load viewport

    };

    function initializeTableConfig(){
        tableAttrib = UICtrl.tableConfig()
        dataCollection = logicCtrl.itemDataConstruct(tableAttrib);
    };

    function buildTable(){        
        var d = UICtrl.tableConstructor(dataCollection);     
        removeItem(d);
        console.log(eventFunctions[4])
    }

    function closeTable(){
        let elements = document.getElementsByClassName('table-0');
        while(elements.length > 0){
            elements[0].parentNode.removeChild(elements[0]);
        }
    }

    function closeInputList(){
        let elements = document.getElementsByClassName('inputform');
        while(elements.length > 0){
            elements[0].parentNode.removeChild(elements[0]);
        }
    }

    function mainMenuEAL(btnEventID, bStr){                                                    // Landing Page/mainMenuEAL
        let i = 0;
        while(i < btnEventID[0].length){                                                    // iterate over mainMenuEALbtn elements
            let z = document.getElementById(btnEventID[0][i]);

            function btnOnClick(valID){                                                     // conditional declaration of onclick function
                if(bStr[valID] === "new Item"){                                             
                    return function(){
                        closeInputList()
                        newItem();
                    }
                }else if(bStr[valID] === "show Table"){
                    return function(){
                        closeInputList();
                        buildTable();
                        console.log(`show Table`)
                    }
                }else if(bStr[valID] === "show Tiles"){
                    return function(){
                        try{closeTable();}
                        catch(err){console.log(err)}
                        try{closeInputList();}
                        catch(err){console.log(err)}
                        //tiles function();
                    }
                }else if(bStr[valID] === "options"){
                    return function(){
                        //dropDownOptions();
                    }
                }else{console.log(`mainMenuEAL error, strings do not match`)}
            };
            eventFunctions[3][i] = btnOnClick(i);                                           // call onclick function with counterattribute
            z.addEventListener("click", eventFunctions[3][i]);                              // set eventlistenerattribute & link to function
            i++
        }
    }

    function newItem(){

        additemELID = UICtrl.addItemAttribList(tableAttrib);
        inputElementsAEL(additemELID.inputElements, additemELID.btnElements, additemELID.tableAtrib, additemELID.btnStrings)
    }

    function addItem(newValues){
        console.log(dataCollection)
        var newdataCollection = logicCtrl.itemDataConstruct(newValues, dataCollection);
        console.log(newdataCollection)
        console.log(dataCollection)
       // dataCollection = newdataCollection


    }

    function removeItem(remID){
        let i=0;
        while(i < remID.length){
            table = remID[i][0],
            row = remID[i][1],
            col = remID[i][2];
            eventFunctions[4][i] = createmethod(table,row);
            document.getElementById(`del-${table}-${row}-${col}`).addEventListener('click',eventFunctions[4][i])
        }
        function createmethod(t,r){
            dataCollection[t].splice(r,1);
            closeTable();
            buildTable();
        }
    }

    function inputElementsAEL(inputEventID, btnEventID, tAttrib, bStr){                  // CONNECT HTML ID STRING TO EVENT LISTENER
        let i = 0; 
        position = 'fixed position';

        while(i < inputEventID.length){                                                     // iterate over input elements          
            let z = document.getElementById(inputEventID[i]);

            function createFocusin(valID){                                                  // onfocus-in function declaration
                return function(){                                                          // return anonymous function into eventFunctions()
                    if(z.value != tAttrib[valID][1]){
                        console.log("do Nothing");
                    }else if(z.value === tAttrib[valID][1]){
                        z.value = "";
                    }   
                }
            };
            function createFocusout(valID){                                                 // onfocus-out function declaration
                return function(){                                                          // return anonymous function into eventFunctions()
                    if(z.value === ""){
                        z.value = tAttrib[valID][1];
                    }   
                }
            };
            eventFunctions[0][i] = createFocusin(i);                                        // call onfocus-in & out function with counterattribute
            eventFunctions[1][i] = createFocusout(i);                                       

            z.addEventListener("focusin", eventFunctions[0][i]);                            // set eventlistenerattribute & link to function
            z.addEventListener("focusout", eventFunctions[1][i]);                               
            i++
        }                                                                   
        i = 0;
        while(i < btnEventID[1].length){                                                       // iterate over btn elements
            let z = document.getElementById(btnEventID[1][i]);

            function btnOnClick(valID){                                                     // conditional declaration of onclick function
                if(bStr[valID] === "add"){
                    return function(){
                        let iVal = UICtrl.readInputList();
                        addItem(iVal)
                        closeInputList();
                        newItem();
                    }
                }else if(bStr[valID] === "clear"){
                    return function(){
                        UICtrl.setInputDefault();
                        console.log(`clear entry`)
                    }
                }else if(bStr[valID] === "close"){
                    return function(){
                        closeInputList()
                    }
                }else if(bStr[valID] === "random fill"){
                    return function(){
                        filler.inputExample(inputEventID);
                    }
                }else{console.log(`counting error, strings do not match`)}
            };
            eventFunctions[2][i] = btnOnClick(i);                                           // call onclick function with counterattribute
            z.addEventListener("click", eventFunctions[2][i]);                              // set eventlistenerattribute & link to function
            i++
        }
    };

    var filler = (function(){
        var X

        

        var fill = [
            ['netherlands', 'limburg', 'ron schwanson', '12-12-2012', 'merlot', "red", 'rond', '12', '5', 'geen invoer', 'geen invoer'],
            ['Frankrijk', 'Cotes du rohne', 'alie baby', '03-08-2014', 'cabernet-sauvignon', 'white', 'fris', '19', '20', 'none', 'geen invoer'],
            ['spanje', 'la Rioja', 'El casa del vino', '02-07-2007', 'merlot', 'red', 'soepel', '15', '24', 'even laten ademen', 'none'],
            ['Italie', 'prosecco', 'Casa di mama', '02-07-2007', 'Rioja', 'red', 'soepel', '15', '24', 'Zit niet te dromen', '(,),)'],
            ['China', 'Wuhan', 'LaMerica', '01-01-2020', 'Corona', 'red', 'Ziekmakend', 'free', '100k+', 'Apocalyps', 'Dead'],
            ['Chili', 'Maule', 'Puroandes Reserve', '2018', 'Sauvignon Blanc', 'white', 'Fresh aromas of tropical fruits', '10.52', '24', 'Enjoyable', 'none']
        ];       
            
        return{
            inputExample: function(ID){
                let Y = 0
                let Z = Math.floor(Math.random()*fill.length);
                if(Z === X){
                    if(X === 0){
                        Z++
                    }else{Z--}
                }X = Z;
                
                while(Y < fill[X].length){
                    document.getElementById(ID[Y]).value = fill[X][Y];
                    Y++;
                }
            }
        }
        
    })()

    return {
        init: function() {                              // initialize application
            landingView();
        }
    }
    
})(LogicController, UIController);

CtrlAgent.init();
