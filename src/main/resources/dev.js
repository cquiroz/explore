import "./theme/semantic.less";
import "./less/style.less";
import "./src/css/aladin.css";

import App from "sjs/root-fastopt.js";
import React from "react";

// var $ = require("jquery");
//
// /* source : http://stackoverflow.com/a/8764051 */
// $.urlParam = function(name, queryString) {
//   if (queryString === undefined) {
//     queryString = location.search;
//   }
//   return (
//     decodeURIComponent(
//       (new RegExp("[?|&]" + name + "=" + "([^&;]+?)(&|#|;|$)").exec(
//         queryString
//       ) || [, ""])[1].replace(/\+/g, "%20")
//     ) || null
//   );
// };

var aladin = require("./src/js/Aladin");
// var A = require("./src/js/cds");
// console.log("aladin");
console.log("A  ");
// console.log(A);

// Enable why did you update plugin
if (process.env.NODE_ENV !== "production") {
  const { whyDidYouUpdate } = require("why-did-you-update");
  whyDidYouUpdate(React, {
    exclude: [
      "GridItem",
      "Resizable",
      "Draggable",
      "DraggableCore",
      "AutoSizer"
    ]
  });
}

if (module.hot) {
  module.hot.accept();
  App.OT.runIOApp();
}
