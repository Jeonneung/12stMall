<template>
    <div>
        <Number
            label="StockId"
            v-model="value.stockId"
            :editMode="editMode"
        />
        <String
            label="StockName"
            v-model="value.stockName"
            :editMode="editMode"
        />
        <Number
            label="StockQuantity"
            v-model="value.stockQuantity"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Inventory',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "inventories",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
