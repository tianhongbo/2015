
/*
 * GET home page.
 */

exports.index = function(req, res){
  res.render('index', { title: 'SJSU CMPE 281 Lab #1' });
};