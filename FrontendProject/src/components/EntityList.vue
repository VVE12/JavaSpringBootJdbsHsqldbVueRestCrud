<template>
  <div align="center">
    <table border="1" cellpadding="10">
      <thead align="center">
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Description</th>
          <th>Date</th>
          <th>Storage</th>
          <th>Reserved</th>
          <th class="tdh">Actions</th>
        </tr>
      </thead>
      <tbody align="center" v-for="entity in entities" :key="entity.id">
        <td>{{entity.id}}</td>
        <td>{{entity.name}}</td>
        <td>{{entity.description}}</td>
        <td>{{entity.date}}</td>
        <td>{{entity.storage}}</td>
        <td>{{entity.reserved}}</td>
        <td>
          <button class="btn btn-secondary" v-on:click="updateEntity(entity)">Edit</button>
          <button class="btn btn-danger" v-on:click="deleteEntity(entity.id)">Delete</button>
        </td>
      </tbody>
    </table>
  </div>
</template>

<script>
import http from "../http-common";
import store from '../store';

export default {
  name: "entities-list",
  data() {
    return {
      entities: [],
    };
  },
  methods: {
    refresh() {
      http
        .get()
        .then((response) => {
          this.entities = response.data;
          console.log(response.data);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    updateEntity(entity) {
      store.data = entity;
      this.$router.push("/edit");
    },
    deleteEntity(id) {
      http.delete("/delete=" + id).then(() => {
        this.refresh();
      });
    },
  },
  mounted() {
    this.refresh();
  },
};
</script>

<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: auto;
}

td,
th {
  width: 5em;
}

.tdh {
  display: flex;
  width: 9em;
  border: none;
  padding-left: 30%;
}
</style>
