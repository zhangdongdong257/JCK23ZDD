
1.远程登录 shell 服务器（连接方式查看入学须知贴）。<br>
输入ssh jck282141@shell.ceshiren.com 回车 <br>
输入密码 <br>
![img.png](img.png)


2.启动 python 服务：<br>
检查服务状态。<br>
浏览器访问服务。<br>
python -m http.server 8666<br>
ps -ef |grep python<br>
netstat -nlp |grep 8666<br>
![img_4.png](img_4.png)
top
![img_3.png](img_3.png)
![img_2.png](img_2.png)
http://shell.ceshiren.com:8666/
![img_1.png](img_1.png)


3.启动 ceshiren jar 包：<br>
检查服务状态。<br>
浏览器访问服务。<br>
java -jar zdd/ceshiren.jar --server.port=8777
![img_5.png](img_5.png)
ps -ef |grep ceshiren<br>
netstat -nlp | grep :8777
![img_7.png](img_7.png)
top
![img_8.png](img_8.png)
http://shell.ceshiren.com:8777/
![img_6.png](img_6.png)

nohup java -jar zdd/ceshiren.jar --server.port=8555 > nohup.out 2>&1 &<br>
![img_10.png](img_10.png)
http://shell.ceshiren.com:8555/
![img_11.png](img_11.png)


4.搭建 PetClinic 宠物医院。<br>
使用 SQL 语句新增数据宠物主人数据。<br>
在 Petclinic 页面中新增宠物主人信息。<br>
编写 SQL 语句查询新增数据的正确性。<br>

端口选择：8090-9000 之间的某一个，不要冲突。<br>
提交服务启动之后的浏览器访问截图即可。



