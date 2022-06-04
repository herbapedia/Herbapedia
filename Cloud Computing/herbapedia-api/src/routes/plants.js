const express = require("express");
const router = express.Router();
const {middleware_admin, middleware_user} = require("../helpers/authorize")
// Load Controller
const { index, show } = require("../controllers/plants");

router.get("/", middleware_user, index)
router.get("/:id", middleware_user, show)

module.exports = router;
