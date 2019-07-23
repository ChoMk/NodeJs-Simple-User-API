const express = require('express');
const router = express.Router();
const controller = require('./user.controller');

router.delete('/:id', controller.destroy);
router.get('/:id', controller.show);
router.get('/', controller.index);
router.post('/', controller.create);



module.exports = router;