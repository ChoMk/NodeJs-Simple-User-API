const assert = require('assert');
const should = require('should');
const request = require('supertest');
const app = require('../../app');
/*
describe('GET /users', () => {
    it('should return 200 status code', () => {
    assert.equal(true, true)//분기
    console.log('test 1');
    });//실행
    it('should return 202 status code', () => {
        assert.equal(true, true)//분기
        console.log('test 2');
        });//실행
  });//설명
*/
/*describe('GET /users', () => {
  it('should return 200 status code', () => {
    (2).should.be.equal(2)
  });
});*/
describe('GET /users', () => {
    it('should return 200 status code', (done) => {
      request(app)
          .get('/users')
          .expect(200)
          .end((err, res) => {
            if (err) throw err;
            done();
          })
    });
  });