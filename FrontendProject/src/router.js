import Vue from "vue";
import Router from "vue-router";
import EntityList from "./components/EntityList.vue";
import AddEntity from "./components/AddEntity.vue";
import EditEntity from "./components/EditEntity.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "entities",
      component: EntityList,
    },
    {
      path: "/add",
      name: "add",
      component: AddEntity
    },
    {
      path: "/edit",
      name: "edit",
      component: EditEntity
    },
  ]
});