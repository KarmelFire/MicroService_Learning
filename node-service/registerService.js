const axios = require("axios");

const nacosUrl = "http://localhost:8848/nacos/v1/ns/instance"; // Nacos 服务注册接口

const registerService = async () => {
  try {
    const response = await axios.post(nacosUrl, null, {
      params: {
        // 注册的服务信息
        serviceName: "node-service", // 服务名称
        ip: "localhost", // 服务的 IP 地址
        port: 8085, // 服务的端口
        clusterName: "DEFAULT", // 集群名称（通常使用默认集群）
        namespaceId: "public", // 默认命名空间
        username: "nacos", // 如果有用户名，请在此处填写
        password: "nacos",
      },
    });

    console.log("Service registered successfully:", response.data);
  } catch (error) {
    console.error("Error registering service:", error);
  }
};

registerService();
