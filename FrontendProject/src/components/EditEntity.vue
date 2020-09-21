<template>
  <div class="submitform">
    <h3>Edit</h3>
    <div align="center">
      <br />
      <table cellpadding="10">
        <tr>
          <td>ID</td>
          <td>
            <input class="form-control" type="number" v-model="entity.id" readonly name="id" />
          </td>
        </tr>
        <tr>
          <td>Name</td>
          <td>
            <input class="form-control" type="text" v-model="entity.name" name="name" />
          </td>
        </tr>
        <tr>
          <td>Description</td>
          <td>
            <input class="form-control" type="text" v-model="entity.description" name="description" />
          </td>
        </tr>
        <tr>
          <td>Date</td>
          <td>
            <input class="form-control" type="text" v-model="entity.date" name="date" />
          </td>
        </tr>
        <tr>
          <td>Storage</td>
          <td>
            <input class="form-control" type="number" v-model="entity.storage" name="storage" />
          </td>
        </tr>
        <tr>
          <td>Reserved</td>
          <td>
            <input class="form-control" type="checkbox" v-model="entity.reserved" name="reserved" />
          </td>
        </tr>
      </table>
      <br />
      <button class="btn btn-success" v-on:click="updateEntity">Save</button>
    </div>
  </div>
</template>

<script>
import http from "../http-common";
import store from "../store.js";

export default {
  name: "edit-entity",
  data() {
    return {
      entity: {
        id: store.data.id,
        name: store.data.name,
        description: store.data.description,
        date: store.data.date,
        storage: store.data.storage,
        reserved: store.data.reserved,
      }
    };
  },
  methods: {
    updateEntity() {
      var data = {
        id: this.entity.id,
        name: this.entity.name,
        description: this.entity.description,
        date: this.entity.date,
        storage: this.entity.storage,
        reserved: this.entity.reserved,
      };
      
      http.put("update=" + data.id, data).then(() => {
        this.$router.push("/");
      });
    },
  },
};
</script>

<style>
.submitform {
  max-width: 300px;
  margin: auto;
}
.form-control {
  width: auto;
}
</style>
