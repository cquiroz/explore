import "./theme/semantic.less";
import "./less/style.less";

import App from "sjs/root-fastopt.js";
import React from "react";

// Enable why did you update plugin
if (process.env.NODE_ENV !== "production") {
  const { whyDidYouUpdate } = require("why-did-you-update");
  whyDidYouUpdate(React, {
    exclude: ["Draggable", "DraggableCore", "AutoSizer"]
  });
}

if (module.hot) {
  module.hot.accept();
  App.OT.main();
}
