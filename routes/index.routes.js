const express = require("express")
const router = require("express").Router();

/* GET home page. */
router.post('/hi', function(req, res, next) {
  res.render('index', { title: 'Express' });
});


module.exports = router;
