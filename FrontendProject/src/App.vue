<template>
  <div id="app" class="container-fluid">
    <div class="site-info">
      <h3>Entities Data</h3>
    </div>
    <nav>
      <router-link class="btn btn-primary" to="/">Home</router-link>
      <router-link class="btn btn-primary" to="/add">Add New Entity</router-link>
    </nav>
    <br />
    <router-view />
  </div>
</template>

<script>
export default {
  name: "app",
};
</script>

<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
  margin-top: 20px;
}

.btn-primary {
  margin-right: 5px;
}

.container-fluid {
  text-align: center;
}
</style>
