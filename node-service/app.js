const express = require("express");
const app = express();
const port = 8085;

// 添加一个简单的接口
app.get("/hello", (req, res) => {
  res.send("成功启用node-service！");
});

// 启动服务
app.listen(port, () => {
  console.log(`Node.js Microservice running on port ${port}`);
});
