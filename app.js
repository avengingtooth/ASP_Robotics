const express = require('express')
const app = express()
const port = 3000
const path = require('path')

app.set('views', __dirname + '/views');
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
  res.sendFile('./index.html', {root: __dirname + '/views'})
})

app.get('/sponsors', (req, res) => {
  res.sendFile('./sponsors.html', {root: __dirname + '/views'})
})

app.get('/projects', (req, res) => {
  res.sendFile('./projects.html', {root: __dirname + '/views'})
})

app.get('/events', (req, res) => {
  res.sendFile('./events.html', {root: __dirname + '/views'})
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})